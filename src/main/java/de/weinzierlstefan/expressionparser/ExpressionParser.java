package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.parser.Operation;
import de.weinzierlstefan.expressionparser.parser.ParseException;
import de.weinzierlstefan.expressionparser.parser.Parser;
import de.weinzierlstefan.expressionparser.value.*;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExpressionParser {
  public ExpressionParser() {
    valueContainerList.add(defaultValueHolder);

    defaultValueHolder.set("false", ValueBoolean.FALSE);
    defaultValueHolder.set("true", ValueBoolean.TRUE);
  }

  /**
   * Parses the provided expression and returns {@link Expression}
   * @param expr
   * @return
   * @throws ExpressionException
   */
  public Expression parse(String expr) throws ExpressionException {
    Executor executor = executorCache.get(expr);
    if (executor == null) {
      Operation operation;
      try {
        Parser calc = new Parser(new ByteArrayInputStream(expr.getBytes(StandardCharsets.UTF_8)));
        operation = calc.parse();
      } catch (ParseException ex) {
        throw new ExpressionException(ex);
      }

      executor = convert(operation);
    }
    executorCache.put(expr, executor);

    ExecutorContext ctx = new ExecutorContext();
    ctx.setMathContext(mathContext);
    ctx.addValueContainers(valueContainerList);

    return new Expression(executor, ctx);
  }

  private Executor convert(Operation op) throws ExpressionException {
    switch(op.getType()) {
      case Operation.INTEGER_LITERAL:
        return handleIntegerLiteral(op);

      case Operation.ADD:
        return handleAdd(op);

      case Operation.SUB:
        return handleSub(op);

      case Operation.MUL:
        return handleMul(op);

      case Operation.DIV:
        return handleDiv(op);

      case Operation.NEGATE:
        return handleNegate(op);

      case Operation.HEX_LITERAL:
        return handleHexLiteral(op);

      case Operation.REAL_LITERAL:
        return handleRealLiteral(op);

      case Operation.BINARY_LITERAL:
        return handleBinaryLiteral(op);

      case Operation.SIMPLE_STRING_LITERAL:
      case Operation.DOUBLE_STRING_LITERAL:
        return handleStringLiteral(op);

      case Operation.FUNCTION_CALL:
        return handleFunctionCall(op);

      case Operation.MOD:
        return handleMod(op);

      case Operation.SHIFT_LEFT:
        return handleShiftLeft(op);

      case Operation.SHIFT_RIGHT:
        return handleShiftRight(op);

      case Operation.CMP_EQ:
        return handleCmpEQ(op);

      case Operation.CMP_NE:
        return handleCmpNE(op);

      case Operation.CMP_GT:
        return handleCmpGT(op);

      case Operation.CMP_GE:
        return handleCmpGE(op);

      case Operation.CMP_LT:
        return handleCmpLT(op);

      case Operation.CMP_LE:
        return handleCmpLE(op);

      case Operation.VARIABLE:
        return handleVariable(op);

      case Operation.TERNARY:
        return handleTernary(op);

      case Operation.WITH:
        return handleWith(op);

      case Operation.AS:
        throw new ExpressionException("AS not expected here");

      case Operation.BOOL_AND:
        return handleBoolAnd(op);

      case Operation.BOOL_OR:
        return handleBoolOr(op);

      case Operation.BOOL_XOR:
        return handleBoolXor(op);

      case Operation.BOOL_NOT:
        return handleBoolNot(op);

      case Operation.BIT_AND:
        return handleBitAnd(op);

      case Operation.BIT_OR:
        return handleBitOr(op);

      case Operation.BIT_XOR:
        return handleBitXor(op);

      case Operation.BIT_NOT:
        return handleBitNot(op);

      case Operation.VARIABLE_ESC:
        return handleVariableEsc(op);

      case Operation.ARRAY_LIST:
        return handleArrayList(op);

      case Operation.SUFFIXED:
        return handleSuffixed(op);

    }

    throw new ExpressionException("Unknown Operation");
  }

  private Executor handleSuffixed(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      Value value = executorList.get(0).exec(ctx);

      if (!value.isArray()) {
        throw new ExpressionException("Value must be a array");
      }

      throw new ExpressionException("not ready");

      /*List<Value> valueList = getValueList(executorList, ctx);

      return value;*/
    };
  }

  private Executor handleArrayList(Operation op) throws ExpressionException {
    final List<ArrayEntry> executorList = new ArrayList<>();
    List<Operation> operationList = op.getOperationList();
    for(Operation op2 : operationList) {
      if (op2.getType()!=Operation.ARRAY_ENTRY) {
        throw new ExpressionException("Wrong Operation-Type");
      }

      ArrayEntry entry = new ArrayEntry();
      entry.value = convert(op2.getOperationList().get(0));

      if (op2.getOperationList().get(1)!=null) {
        entry.key = entry.value;
        entry.value = convert(op2.getOperationList().get(1));
      }

      executorList.add(entry);
    }

    return ctx -> {
      Map<Value, Value> valueMap = new TreeMap<>();
      long key=0;
      for(ArrayEntry entry: executorList) {
        Value value = entry.value.exec(ctx);
        Value keyValue;
        if (entry.key!=null) {
          keyValue = entry.key.exec(ctx);
        } else {
          keyValue = Value.of(key);
          valueMap.put(Value.of(key++), value);
        }

        valueMap.put(keyValue, value);

        if (keyValue.isNumber()) {
          key = keyValue.toLong()+1;
        }
      }

      return Value.of(valueMap);
    };
  }


  private Executor handleMul(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Number expected");
      }

      BigDecimal result = valueList.getBigDecimal(0);
      for(int i=1; i<valueList.size(); ++i) {
        result = result.multiply(valueList.getBigDecimal(i), ctx.getMathContext());
      }
      return Value.of(result);
    };
  }

  private Executor handleDiv(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Number expected");
      }

      BigDecimal result = valueList.getBigDecimal(0);
      for(int i=1; i<valueList.size(); ++i) {
        result = result.divide(valueList.getBigDecimal(i), ctx.getMathContext());
      }
      return Value.of(result);
    };
  }

  private Executor handleMod(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Number expected");
      }

      BigDecimal result = valueList.getBigDecimal(0);
      for(int i=1; i<valueList.size(); ++i) {
        BigDecimal[] dr = result.divideAndRemainder(valueList.getBigDecimal(i), ctx.getMathContext());
        result = dr[1];
      }
      return Value.of(result);
    };
  }

  private Executor handleNegate(Operation op) throws ExpressionException {
    ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=1) {
      throw new ExpressionException("More than 1 value fro negate present");
    }
    final Executor executor = executorList.get(0);

    return ctx -> {
      Value value = executor.exec(ctx);
      if (value.isNull()) {
        return ValueNull.INSTANCE;
      } else if (!value.isNumber()) {
        throw new ExpressionException("Number expected");
      }

      BigDecimal result = value.toBigDecimal().negate(ctx.getMathContext());
      return Value.of(result);
    };
  }

  private Executor handleHexLiteral(Operation op) {
    return new ValueExecutor(Value.of(new BigInteger(op.getValue().substring(2), 16)));
  }

  private Executor handleRealLiteral(Operation op) {
    return new ValueExecutor(Value.of(new BigDecimal(op.getValue())));
  }

  private Executor handleBinaryLiteral(Operation op) {
    return new ValueExecutor(Value.of(new BigInteger(op.getValue().substring(2), 2)));
  }

  private Executor handleStringLiteral(Operation op) {
    String str = op.getValue();
    return new ValueExecutor(Value.of(str.substring(1, str.length()-1)));
  }

  private Executor handleFunctionCall(Operation op) throws ExpressionException {
    Function func = functionMap.get(op.getValue().toLowerCase());
    if (func==null) {
      throw new ExpressionException("Unknown function: "+op.getValue());
    }

    final ExecutorList executorList = getExecutorList(op);
    if (!func.parameterCount(executorList.size())) {
      throw new ExpressionException("Wrong parameter count for function '"+op.getValue()+"'");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (func.returnsNullOnNull() && valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }
      return func.execute(valueList, ctx);
    };
  }

  private Executor handleSub(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Number expected");
      }

      BigDecimal result = valueList.getBigDecimal(0);
      for(int i=1; i<valueList.size(); ++i) {
        result = result.subtract(valueList.getBigDecimal(i), ctx.getMathContext());
      }
      return Value.of(result);
    };
  }

  private Executor handleIntegerLiteral(Operation op) {
    return new ValueExecutor(Value.of(new BigInteger(op.getValue())));
  }

  private Executor handleAdd(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      boolean number = true;
      for(Value v : valueList) {
        if (v.isNull()) {
          //return ValueNull.INSTANCE;
        } else if (v.isString()) {
          number = false;
        } else if (!v.isNumber()) {
          throw new ExpressionException("String or Number expected");
        }
      }

      if (number) {
        BigDecimal sum = BigDecimal.ZERO;
        for(Value v : valueList) {
          if (v.isNull()) {
            return ValueNull.INSTANCE;
          }
          sum = sum.add(v.toBigDecimal(), ctx.getMathContext());
        }
        return Value.of(sum);
      }

      StringBuilder builder = new StringBuilder();
      for(Value v : valueList) {
        if (!v.isNull()) {
          builder.append(v.toString());
        }
      }
      return Value.of(builder.toString());
    };
  }

  private Executor handleShiftLeft(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for shift");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }
      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Values must be numbers");
      }

      BigInteger bi = valueList.getBigDecimal(0).toBigInteger();
      long shift = valueList.getLong(1);

      bi = bi.shiftLeft((int)shift);

      return Value.of(bi);
    };
  }

  private Executor handleShiftRight(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for shift");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);

      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }
      if (!valueList.allIsNumber()) {
        throw new ExpressionException("Values must be numbers");
      }

      BigInteger bi = valueList.getBigDecimal(0).toBigInteger();
      long shift = valueList.getLong(1);

      bi = bi.shiftRight((int)shift);

      return Value.of(bi);
    };
  }

  private Executor handleCmpEQ(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))==0);
    };
  }

  private Executor handleCmpNE(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))!=0);
    };
  }

  private Executor handleCmpGT(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))>0);
    };
  }

  private Executor handleCmpGE(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))>=0);
    };
  }

  private Executor handleCmpLT(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))<0);
    };
  }

  private Executor handleCmpLE(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      ValueList valueList = getValueList(executorList, ctx);
      if (valueList.anyNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(valueList.get(0).compareTo(valueList.get(1))<=0);
    };
  }

  private Executor handleVariable(Operation op) {
    final String name = op.getValue();
    if (name.toLowerCase().equals("null")) {
      return ctx -> ValueNull.INSTANCE;
    }

    return ctx -> {
      Value value = ctx.getVariable(name);

      if (value==null) {
        throw new ExpressionException("Variable not found");
      }

      return value;
    };
  }

  private Executor handleVariableEsc(Operation op) {
    String name = op.getValue();
    name = name.substring(1, name.length()-1);
    String finalName = name;
    return ctx -> ctx.getVariable(finalName);
  }

  private Executor handleTernary(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);

    if (executorList.size()!=3) {
      throw new ExpressionException("3 Parameter for Ternary needed");
    }

    return ctx -> {
      Value a = executorList.get(0).exec(ctx);

      if (a.toBoolean()) {
        return executorList.get(1).exec(ctx);
      } else {
        return executorList.get(2).exec(ctx);
      }
    };
  }

  private Executor handleWith(Operation op) throws ExpressionException {
    List<Operation> operationList = op.getOperationList();
    final List<String> nameList = new ArrayList<>();
    final List<Executor> executorList = new ArrayList<>();
    for(int i=0; i<operationList.size()-1; ++i) {
      Operation op2 = operationList.get(i);
      if (op2.getType()!=Operation.AS) {
        throw new ExpressionException("AS-Expression required");
      }
      nameList.add(op2.getValue());
      executorList.add(convert(op2.getOperationList().get(0)));
    }


    final Executor exec = convert(operationList.get(operationList.size()-1));
    return ctx -> {
      DefaultValueContainer valueContainer = new DefaultValueContainer();
      for(int i=0; i<executorList.size(); ++i) {
        valueContainer.set(nameList.get(i), executorList.get(i).exec(ctx));
      }

      ExecutorContext ctx2 = new ExecutorContext(ctx);
      ctx2.addValueContainer(valueContainer);

      return exec.exec(ctx2);
    };
  }

  private Executor handleBoolAnd(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value = executorList.get(0).exec(ctx);

      if (!value.toBoolean()) {
        return value;
      }

      return executorList.get(1).exec(ctx);
    };
  }

  private Executor handleBoolOr(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value = executorList.get(0).exec(ctx);

      if (value.toBoolean()) {
        return value;
      }

      return executorList.get(1).exec(ctx);
    };
  }

  private Executor handleBoolXor(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value1 = executorList.get(0).exec(ctx);
      Value value2 = executorList.get(1).exec(ctx);

      return Value.of(value1.toBoolean()!=value2.toBoolean());
    };
  }

  private Executor handleBoolNot(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=1) {
      throw new ExpressionException("Need 1 values for comparison");
    }

    return ctx -> {
      Value value = executorList.get(0).exec(ctx);

      if (value.isNull()) {
        return ValueNull.INSTANCE;
      }

      return Value.of(!value.toBoolean());
    };
  }

  private Executor handleBitAnd(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value1 = executorList.get(0).exec(ctx);
      Value value2 = executorList.get(1).exec(ctx);

      if (value1.isNull() || value2.isNull()) {
        return ValueNull.INSTANCE;
      }
      if (!value1.isNumber() || !value2.isNumber()) {
        throw new ExpressionException("Values must be numbers");
      }

      BigInteger bi1 = value1.toBigDecimal().toBigInteger();
      BigInteger bi2 = value2.toBigDecimal().toBigInteger();

      return Value.of(bi1.and(bi2));
    };
  }

  private Executor handleBitOr(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value1 = executorList.get(0).exec(ctx);
      Value value2 = executorList.get(1).exec(ctx);

      if (value1.isNull() || value2.isNull()) {
        return ValueNull.INSTANCE;
      }
      if (!value1.isNumber() || !value2.isNumber()) {
        throw new ExpressionException("Values must be numbers");
      }

      BigInteger bi1 = value1.toBigDecimal().toBigInteger();
      BigInteger bi2 = value2.toBigDecimal().toBigInteger();

      return Value.of(bi1.or(bi2));
    };
  }

  private Executor handleBitXor(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=2) {
      throw new ExpressionException("Need 2 values for comparison");
    }

    return ctx -> {
      Value value1 = executorList.get(0).exec(ctx);
      Value value2 = executorList.get(1).exec(ctx);

      if (value1.isNull() || value2.isNull()) {
        return ValueNull.INSTANCE;
      }
      if (!value1.isNumber() || !value2.isNumber()) {
        throw new ExpressionException("Values must be numbers");
      }

      BigInteger bi1 = value1.toBigDecimal().toBigInteger();
      BigInteger bi2 = value2.toBigDecimal().toBigInteger();

      return Value.of(bi1.xor(bi2));
    };
  }

  private Executor handleBitNot(Operation op) throws ExpressionException {
    final ExecutorList executorList = getExecutorList(op);
    if (executorList.size()!=1) {
      throw new ExpressionException("Need 1 values for comparison");
    }

    return ctx -> {
      Value value = executorList.get(0).exec(ctx);

      if (value.isNull()) {
        return ValueNull.INSTANCE;
      }
      if (!value.isNumber()) {
        throw new ExpressionException("Value must be a number");
      }

      BigInteger bi = value.toBigDecimal().toBigInteger();

      return Value.of(bi.not());
    };
  }

  private ExecutorList getExecutorList(Operation op) throws ExpressionException {
    ExecutorList executorList = new ExecutorList();
    for(Operation op2 : op.getOperationList()) {
      executorList.add(convert(op2));
    }
    return executorList;
  }

  private ValueList getValueList(ExecutorList executorList, ExecutorContext ctx) throws ExpressionException {
    ValueList valueList = new ValueList();

    for(Executor executor : executorList) {
      valueList.add(executor.exec(ctx));
    }

    return valueList;
  }

  /**
   * Sets the size of the LRU-Cache
   * @param size
   */
  public void setCacheSize(int size) {
    executorCache.setCacheSize(size);
  }

  /**
   * Clears the LRU-Cache
   */
  public void clearCache() {
    executorCache.clear();
  }

  /**
   * Adds a new function to this parser
   * @param function
   */
  public void addFunction(Function function) {
    clearCache();
    functionMap.put(function.getName().toLowerCase(), function);
  }

  /**
   * Convenient function for setting many functions at once
   * @param functions
   */
  public void addFunctions(Collection<Function> functions) {
    functions.forEach(f->addFunction(f));
  }

  /**
   * Sets the value of a variable
   * @param name
   * @param value
   */
  public void setVariable(String name, Value value) {
    defaultValueHolder.set(name.toLowerCase(), value);
  }

  /**
   * Adds a {@link ValueContainer}
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    valueContainerList.add(valueContainer);
  }

  /**
   * Gets the value of a variable
   * @param name
   * @return
   */
  public Value getVariable(String name) {
    name = name.toLowerCase();
    for(int i = valueContainerList.size()-1; i>=0; i--) {
      Value value = valueContainerList.get(i).get(name);
      if (value!=null) {
        return value;
      }
    }

    return null;
  }

  /**
   * Sets the {@link java.math.MathContext} for the parser and the newly generated {@link Expression}
   * @param mathContext
   */
  public void setMathContext(MathContext mathContext) {
    this.mathContext = mathContext;
  }

  private final static class ValueExecutor implements Executor {
    public ValueExecutor(Value value) {
      this.value = value;
    }

    @Override
    public Value exec(ExecutorContext ctx) {
      return value;
    }

    private final Value value;
  }

  private final static class ArrayEntry {
    Executor key = null;
    Executor value = null;
  }

  private final static class ExecutorList extends ArrayList<Executor> {
  }

  private final LRUCache<String, Executor> executorCache = new LRUCache<>(10);

  private final Map<String, Function> functionMap = new HashMap<>();

  private final DefaultValueContainer defaultValueHolder = new DefaultValueContainer();

  private final List<ValueContainer> valueContainerList = new ArrayList<>();

  private MathContext mathContext = MathContext.DECIMAL32;
}
