package com.mtdp.spring.bean.create.factory_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/1/31
 */
public class Main {

    /**
     * Alternative to class attribute for factory-method usage.
     * If this is specified, no class attribute should be used.
     * This must be set to the name of a bean in the current or
     * ancestor factories that contains the relevant factory method.
     * This allows the factory itself to be configured using Dependency
     * Injection, and an instance (rather than static) method to be used.
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");

        Car car1 = applicationContext.getBean(Car.class);
        System.out.println(car1);

        Car car2 = applicationContext.getBean(Car.class);
        System.out.println(car2);
    }
}
