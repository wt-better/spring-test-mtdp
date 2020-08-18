package com.mtdp.spring.bean.create.factroy_method;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/1/31
 */
public class Car {

    private static volatile Car car;

    /**
     * 单例工厂方法
     */
    public static Car getInstance() {
        if (car == null) {
            synchronized (Car.class) {
                if (car == null) {
                    car = new Car();
                }
            }
        }
        return car;
    }
}
