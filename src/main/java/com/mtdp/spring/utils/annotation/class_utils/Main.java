package com.mtdp.spring.utils.annotation.class_utils;

import org.springframework.util.ClassUtils;

import java.util.Arrays;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date Created At 2020/2/24
 */
public class Main {

    public static void main(String[] args) {
        Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(D.class);
        Arrays.stream(allInterfacesForClass).map(Class::getName).forEach(System.out::println);
    }
}
