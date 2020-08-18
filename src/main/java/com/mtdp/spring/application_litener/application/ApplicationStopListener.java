package com.mtdp.spring.application_litener.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/1
 */
public class ApplicationStopListener implements ApplicationListener<ContextStoppedEvent> {

    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("application stop ...");
    }
}
