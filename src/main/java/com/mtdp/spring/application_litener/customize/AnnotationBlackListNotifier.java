package com.mtdp.spring.application_litener.customize;

import org.springframework.context.event.EventListener;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/2
 */
public class AnnotationBlackListNotifier {

    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("notificationAddress = " + event.getAddress() + "\nnotifyContent = " + event.getContent());
    }
}