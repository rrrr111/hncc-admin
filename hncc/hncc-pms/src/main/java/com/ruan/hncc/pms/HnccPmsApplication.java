package com.ruan.hncc.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class HnccPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnccPmsApplication.class, args);
    }




}
