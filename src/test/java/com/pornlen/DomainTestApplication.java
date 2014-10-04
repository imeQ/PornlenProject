package com.pornlen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing(auditorAwareRef = "auditingAware")
@ComponentScan({"com.pornlen.domain", "com.pornlen.dao"})
public class DomainTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainTestApplication.class);
    }
}