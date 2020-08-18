package com.mtdp.spring.bean.register;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/2
 */
@Component
public class Register implements BeanDefinitionRegistryPostProcessor {

    /**
     * 动态注册BeanDefinition
     * 通过这种方式可以自定义注册Bean的名称，同时会autowired Bean
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //1、使用RootBeanDefinition接口操作
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Bean.class);
        beanDefinition.setScope(ConfigurableListableBeanFactory.SCOPE_SINGLETON);
        beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
        registry.registerBeanDefinition("bean", beanDefinition);

        //2、使用BeanDefinitionBuilder进行注册
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Bean1.class);
        builder.setLazyInit(false);
        registry.registerBeanDefinition("bean1", builder.getBeanDefinition());
    }

    /**
     * 通过beanFactory 注册bean
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //2、使用BeanDefinitionBuilder操作
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Bean2.class);
        builder.setLazyInit(false);

        if (beanFactory instanceof DefaultListableBeanFactory) {
            ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("bean2", builder.getBeanDefinition());
        }
    }
}
