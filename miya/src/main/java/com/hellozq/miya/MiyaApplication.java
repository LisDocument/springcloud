package com.hellozq.miya;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author bin
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hellozq.miya.dao")
public class MiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiyaApplication.class, args);
    }
}
