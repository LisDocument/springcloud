package com.hellozq.miya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author bin
 */
@SpringBootApplication
@EnableEurekaClient
public class MiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiyaApplication.class, args);
    }
}
