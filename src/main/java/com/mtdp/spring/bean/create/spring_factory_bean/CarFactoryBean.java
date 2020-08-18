package com.mtdp.spring.bean.create.spring_factory_bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/1/31
 */
public class CarFactoryBean implements FactoryBean<Car> {

    public Car getObject() throws Exception {
        return new Car();
    }

    public Class<?> getObjectType() {
        return Car.class;
    }
}
