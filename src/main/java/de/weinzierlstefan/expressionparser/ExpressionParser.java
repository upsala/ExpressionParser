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
 * This class is used, to parse a expression, cache it and return a {@link Expression} which can evaluated
 */
public class ExpressionParser {
  private final static int DEFAULT_MAX_CACHE_SIZE = 100;
  private final static LRUCache<String, Executor> executorCache = new LRUCache<>(DEFAULT_MAX_CACHE_SIZE);

  private ExpressionParser() {
  }

  /**
   * Parses the provided expression and returns {@link Expression}, where the {@link ExecutorContext} is set
   * @param expr
   * @return
   * @throws ExpressionException
   */
  public static Expression parse(String expr, ExecutorContext executorContext) throws ExpressionException {
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

    return new Expression(executor, executorContext);
  }

  /**
   * Parses the provided expression and returns {@link Expression}
   * @param expr
   * @return
   * @throws ExpressionException
   */
  public static Expression parse(String expr) throws ExpressionException {
    return parse(expr, null);
  }

  /**
   * Sets the size, of the internal (Thread-save) cache
   * @param size
   */
  public static void setCacheSize(int size) {
    executorCache.setCacheSize(size);
  }
}
