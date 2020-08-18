package com.mtdp.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/21
 */
public class Main {

    private static void test1() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("3+4");
        // 	The value is 7.
        System.out.println(expression.getValue(Integer.class));
    }

    private static void test2() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        //Exception:Property or field 'hello' cannot be found on null
        //fix -> "'hello'"
        Expression expression = expressionParser.parseExpression("hello");
        System.out.println(expression.getValue(String.class));
    }

    private static void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        // The value of message is now 'Hello World!'.
        System.out.println(exp.getValue(String.class));
    }

    public static void main(String[] args) {
       test3();
    }
}
