package com.mtdp.spring.utils.annotation.annotatted_element_utils;

import com.mtdp.spring.utils.annotation.annotatted_element_utils.anno.Service;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/19
 */
public class Main {

    private static void test1() {
        boolean annotated = AnnotatedElementUtils.isAnnotated(Bean.class, Service.class);
        System.out.println("AnnotatedElementUtils.isAnnotated -> " + annotated);

        boolean annotationPresent = Bean.class.isAnnotationPresent(Service.class);
        System.out.println("Class.isAnnotationPresent -> " + annotationPresent);
    }

    public static void main(String[] args) {
        //test1();
    }
}
