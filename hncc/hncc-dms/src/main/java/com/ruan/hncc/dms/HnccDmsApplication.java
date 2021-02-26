package com.ruan.hncc.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HnccDmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnccDmsApplication.class, args);
    }

}
