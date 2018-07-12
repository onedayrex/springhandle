package com.onedayrex.git.springhandle.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.onedayrex.git")
@MapperScan("com.onedayrex.git.springhandle.common.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
public class SpringhandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhandleApplication.class, args);
    }
}
