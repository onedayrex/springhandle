package com.onedayrex.git.springhandle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.onedayrex.git.springhandle.mapper")
public class SpringhandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhandleApplication.class, args);
    }
}
