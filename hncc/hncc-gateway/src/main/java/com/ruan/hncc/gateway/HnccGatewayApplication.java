package com.ruan.hncc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HnccGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnccGatewayApplication.class, args);
    }

}
