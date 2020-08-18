package com.mtdp.spring.bean.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/2
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean6.xml");
        Bean bean = applicationContext.getBean(Bean.class);
        Bean1 bean1 = applicationContext.getBean(Bean1.class);
        Bean2 bean2 = applicationContext.getBean(Bean2.class);
        System.out.println(bean.getBeanFactory());
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
