package com.mtdp.spring.spel.spel_parser_config;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/22
 */
public class Main {


    public static void main(String[] args) {
        //autoGrowNullReference -> ？
        //autoGrowCollections -> 集合自动增长
        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);

        ExpressionParser parser = new SpelExpressionParser(configuration);
        /*
         * List必须要有范型信息，否则会抛出异常
         * Unable to grow collection: unable to determine list element type
         */
        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();
        Object value = expression.getValue(demo);

        assert value != null;
        //demo.list will now be a real collection of 4 entries
        System.out.println(demo.list.size());
        //Each entry is a new empty String
        System.out.println(value);
    }
}
