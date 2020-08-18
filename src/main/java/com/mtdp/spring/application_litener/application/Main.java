package com.mtdp.spring.application_litener.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/2/1
 */
public class Main {

    /**
     * spring ApplicationContextEvent 通知机制
     * 举个例子：
     * 0、在spring容器启动的时候会push ContextStartedEvent（容器启动）的事件
     * 参见:org.springframework.context.support.AbstractApplicationContext#start()
     * publishEvent(new ContextStartedEvent(this));
     * <p>
     * 1、spring容器启动过程中会Refresh容器，产生ContextRefreshedEvent（容器刷新）事件
     * 参见:org.springframework.context.support.AbstractApplicationContext#finishRefresh()
     * 在完成Refresh的时候调用ApplicationEventPublisher.pushEvent完成事件的广播进行广播
     * 其中pushEvent使用了ApplicationEventMulticaster组件进行广播。
     * <p>
     * 2、spring容器关闭的时候会push ContextClosedEvent(容器关闭)的事件
     * 参见:org.springframework.context.support.AbstractApplicationContext#doClose()
     * publishEvent(new ContextClosedEvent(this));
     * ...
     * <p>
     * 以上牵扯到如下几个角色：
     * 1) ApplicationEvent
     * 容器相关事件，分为启动事件、刷新事件、关闭事件等等...
     * 2）ApplicationEventPublisher
     * 事件的发布方 - pushEvent
     * 3）ApplicationEventMulticaster
     * 事件广播,，用来分发事件给对应的监听或者说消费者 - multicastEvent(org.springframework.context.ApplicationEvent)
     * 4）ApplicationListener
     * 事件的接收方、监听者 -  onApplicationEvent
     * <p>
     * 源码分析：
     * 1、initApplicationEventMulticaster(); - 初始化广播
     * 2、registerListeners - 注册监听者
     * 3、finishRefresh  - 通知refresh事件
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean4.xml");
        //注意：必须使用start方法启动spring容器，才能触发start事件
        classPathXmlApplicationContext.start();

        classPathXmlApplicationContext.stop();
        classPathXmlApplicationContext.close();


        /**
         * 其中start stop 归属于 LifeCycle接口
         * close，refresh归属于ConfigurableApplicationContext接口
         * ConfigurableApplicationContext接口是LifeCycle接口的子接口
         */
    }
}
