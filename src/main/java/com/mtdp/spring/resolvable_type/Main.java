package com.mtdp.spring.resolvable_type;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Type;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/28
 */
public class Main {

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(Main.class);
        Type type = resolvableType.getType();
        System.out.println(type.getClass());
        System.out.println(type.getTypeName());
    }
}
