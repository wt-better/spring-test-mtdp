package com.mtdp.spring.application_litener.customize;

import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/2
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    // accessor and other methods...


    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}