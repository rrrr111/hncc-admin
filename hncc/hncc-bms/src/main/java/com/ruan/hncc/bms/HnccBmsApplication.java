package com.ruan.hncc.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class HnccBmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnccBmsApplication.class, args);
    }

}
