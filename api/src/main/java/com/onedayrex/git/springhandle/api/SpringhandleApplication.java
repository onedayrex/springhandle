package com.onedayrex.git.springhandle.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.onedayrex.git")
@MapperScan("com.onedayrex.git.springhandle.common.mapper")
public class SpringhandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhandleApplication.class, args);
    }
}
