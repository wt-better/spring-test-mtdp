package com.mtdp.spring.application_litener.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/1
 */
public class ApplicationStartListener implements ApplicationListener<ContextStartedEvent> {

    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("application start ...");
    }
}
