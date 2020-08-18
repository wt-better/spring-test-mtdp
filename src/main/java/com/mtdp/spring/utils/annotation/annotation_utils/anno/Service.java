package com.mtdp.spring.utils.annotation.annotation_utils.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
public @interface Service {

    String value() default "";

    Class<?>[] classes() default {};
}
