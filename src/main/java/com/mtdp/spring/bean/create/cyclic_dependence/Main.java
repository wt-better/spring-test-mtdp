package com.mtdp.spring.bean.create.cyclic_dependence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/6/12
 */
@Configuration
@ComponentScan(basePackages = {"com.mtdp.spring.bean.create.cyclic_dependence"})
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        applicationContext.close();
    }

}




