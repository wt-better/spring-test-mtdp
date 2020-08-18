package com.mtdp.spring.utils.annotation.annotation_utils.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Reference {

    String value();

    int timeout() default 3000;

    Service service() default @Service(value = "hello");
}
