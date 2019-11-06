package com.giant;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class AtomikosTestMainApplication {

    public static void main(String[] args) {

        SpringApplication.run(AtomikosTestMainApplication.class, args);
    }
}
