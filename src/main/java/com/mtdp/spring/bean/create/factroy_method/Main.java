package com.mtdp.spring.bean.create.factroy_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/1/31
 */
public class Main {

    /**
     * factory-method
     * <p>
     * The name of a factory method to use to create this object. Use
     * constructor-arg elements to specify arguments to the factory method,
     * if it takes arguments. Autowiring does not apply to factory methods.
     * <p>
     * If the "class" attribute is present, the factory method will be a static
     * method on the class specified by the "class" attribute on this bean
     * definition. Often this will be the same class as that of the constructed
     * object - for example, when the factory method is used as an alternative
     * to a constructor. However, it may be on a different class. In that case,
     * the created object will *not* be of the class specified in the "class"
     * attribute. This is analogous to FactoryBean behavior.
     * <p>
     * If the "factory-bean" attribute is present, the "class" attribute is not
     * used, and the factory method will be an instance method on the object
     * returned from a getBean call with the specified bean name. The factory
     * bean may be defined as a singleton or a prototype.
     * <p>
     * The factory method can have any number of arguments. Autowiring is not
     * supported. Use indexed constructor-arg elements in conjunction with the
     * factory-method attribute.
     * <p>
     * Setter Injection can be used in conjunction with a factory method.
     * Method Injection cannot, as the factory method returns an instance,
     * which will be used when the container creates the bean.
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");

        Car car1 = applicationContext.getBean(Car.class);
        System.out.println(car1);

        Car car2 = applicationContext.getBean(Car.class);
        System.out.println(car2);
    }
}
