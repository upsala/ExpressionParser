package de.weinzierlstefan.expressionparser;

import de.weinzierlstefan.expressionparser.parser.ParserLexer;
import de.weinzierlstefan.expressionparser.parser.ParserParser;
import de.weinzierlstefan.expressionparser.tools.LRUCache;
import de.weinzierlstefan.expressionparser.value.DefaultValueContainer;
import de.weinzierlstefan.expressionparser.value.Value;
import de.weinzierlstefan.expressionparser.value.ValueContainer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * 
 */
public class ExpressionParser {
  private final static int DEFAULT_MAX_CACHE_SIZE = 100;
  private final static LRUCache<String, Executor> executorCache = new LRUCache<>(DEFAULT_MAX_CACHE_SIZE);
  private final Map<String, Function> functionMap = new HashMap<>();
  private final DefaultValueContainer defaultValueHolder = new DefaultValueContainer();
  private final List<ValueContainer> valueContainerList = new ArrayList<>();

  public ExpressionParser() {
    valueContainerList.add(defaultValueHolder);
  }

  /**
   * Parses the provided expression and returns {@link Expression}
   *
   * @param expr
   * @return
   * @throws ExpressionException
   */
  public Expression parse(String expr) throws ExpressionException {
    Executor executor = executorCache.get(expr);
    if (executor == null) {
      CharStream chars = CharStreams.fromString(expr);

      Lexer lexer = new ParserLexer(chars);
      CommonTokenStream tokens = new CommonTokenStream(lexer);

      ParserParser parser = new ParserParser(tokens);
      ParseTree tree = parser.expression();

      ParserVisitor calculator = new ParserVisitor();
      executor = calculator.visit(tree);
    }
    executorCache.put(expr, executor);

    ExecutorContext ctx = new ExecutorContext();
    ctx.addValueContainers(valueContainerList);
    ctx.setFunctionMap(functionMap);

    return new Expression(executor, ctx);
  }

  /**
   * Adds a new function to this parser
   *
   * @param function
   */
  public void addFunction(Function function) {
    functionMap.put(function.getName().toLowerCase(), function);
  }

  /**
   * Convenient function for setting many functions at once
   *
   * @param functions
   */
  public void addFunctions(Collection<Function> functions) {
    functions.forEach(this::addFunction);
  }

  /**
   * Sets the value of a variable
   *
   * @param name
   * @param value
   */
  public void setVariable(String name, Value value) {
    defaultValueHolder.set(name, value);
  }

  /**
   * Sets the value of a variable
   *
   * @param name
   * @param value
   */
  public void setVariable(String name, Object value) {
    defaultValueHolder.set(name, value);
  }

  /**
   * Adds a {@link ValueContainer}
   *
   * @param valueContainer
   */
  public void addValueContainer(ValueContainer valueContainer) {
    valueContainerList.add(valueContainer);
  }

  /**
   * Gets the value of a variable
   *
   * @param name
   * @return
   */
  public Value getVariable(String name) {
    for (int i = valueContainerList.size() - 1; i >= 0; i--) {
      Value value = valueContainerList.get(i).get(name);
      if (value != null) {
        return value;
      }
    }

    return null;
  }

  /**
   * Sets the size, of the internal (Thread-save) cache
   * @param size
   */
  private void setCacheSize(int size) {
    executorCache.setCacheSize(size);
  }
}
