package com.mtdp.spring.application_litener.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/1
 */
public class ApplicationRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("application refreshed ...");
    }
}
