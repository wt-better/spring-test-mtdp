package com.mtdp.spring.bean.create.spring_factory_bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/1/31
 */
public class Main {

    /**
     * Used to dereference a {@link FactoryBean} instance and distinguish it from
     * beans <i>created</i> by the FactoryBean. For example, if the bean named
     * {@code myJndiObject} is a FactoryBean, getting {@code &myJndiObject}
     * will return the factory, not the instance returned by the factory.
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean3.xml");

        Object car = applicationContext.getBean("car");
        System.out.println(car.getClass());

        Object carFactoryBean = applicationContext.getBean(BeanFactory.FACTORY_BEAN_PREFIX + "car");
        System.out.println(carFactoryBean.getClass());
    }
}
