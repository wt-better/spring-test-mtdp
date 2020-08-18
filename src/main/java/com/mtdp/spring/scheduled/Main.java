package com.mtdp.spring.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author <a href="wangte@meitaun.com">Te</a>
 * @date created at 2019/6/2
 */
@Component
public class Main {

    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledTask() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) throws IOException {
        new AnnotationConfigApplicationContext(RootConfig.class);

        System.in.read();
    }

    @Configuration
    @EnableScheduling
    @ComponentScan(basePackages = {"com.mtdp.spring.scheduled"})
    public static class RootConfig {

        @Bean
        public User user() {
            return new User();
        }

    }

    public static class User {

    }
}
