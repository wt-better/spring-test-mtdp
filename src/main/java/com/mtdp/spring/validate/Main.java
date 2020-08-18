package com.mtdp.spring.validate;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Role;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/6/2
 */
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.close();
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public static LocalValidatorFactoryBean defaultValidator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public static MethodValidationPostProcessor methodValidationPostProcessor(@Lazy Validator validator) {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator);
        postProcessor.setProxyTargetClass(true);
        return postProcessor;
    }

    @Bean
    public DemoFactoryBean demoFactoryBean() {
        return new DemoFactoryBean();
    }

    @Validated
    static class DemoFactoryBean implements FactoryBean<Demo> {

        @Override
        public Demo getObject() throws Exception {
            return new Demo();
        }

        @Override
        public Class<?> getObjectType() {
            return Demo.class;
        }

        @Override
        public boolean isSingleton() {
            return true;
        }

    }

    static class Demo {

    }

}
