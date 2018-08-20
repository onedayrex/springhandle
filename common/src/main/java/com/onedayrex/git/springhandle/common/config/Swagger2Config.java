package com.onedayrex.git.springhandle.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//开启swagger2
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Value("${swagger.enable}")
    private Boolean enable;

    //创建Docket的bean信息
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否打开文档配置
                .enable(enable).select()
                //扫描包
                .apis(RequestHandlerSelectors.basePackage("com.onedayrex.git.springhandle.api.controller"))
                //路径处理
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("onedayrex")
                .version("1.1.0")
                .contact(new Contact("onedayrex","http://github.com.onedayrex","1115757866@qq.com"))
                .build();
    }
    //需要引入swagger-ui的包
    //文档地址 http://localhost:8080/swagger-ui.html
}
