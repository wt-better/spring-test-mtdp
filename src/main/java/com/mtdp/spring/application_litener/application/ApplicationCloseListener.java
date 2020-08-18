package com.mtdp.spring.application_litener.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/1
 */
public class ApplicationCloseListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("application close ... ");
    }
}
