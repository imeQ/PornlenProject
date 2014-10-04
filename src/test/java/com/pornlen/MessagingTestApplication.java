package com.pornlen;

import com.pornlen.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {OptionalExtPropsConfig.class, ScheduleConfig.class, WebFilterConfig.class, WebJsfConfig.class, WebSecurityConfig.class})
@ComponentScan({"com.pornlen.config", "com.pornlen.service"})
public class MessagingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingTestApplication.class);
    }
}