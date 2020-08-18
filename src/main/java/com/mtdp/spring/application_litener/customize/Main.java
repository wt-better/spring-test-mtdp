package com.mtdp.spring.application_litener.customize;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/2
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean5.xml");
        EmailService emailService = applicationContext.getBean(EmailService.class);
        emailService.sendEmail("john.doe@example.org","Hello,My Friend!");
    }
}
