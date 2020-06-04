package com.network;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.network.good.mapper")
@SpringBootApplication
public class StuserverServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StuserverServiceApplication.class, args);
    }
}
