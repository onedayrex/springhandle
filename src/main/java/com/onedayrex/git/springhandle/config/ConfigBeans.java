package com.onedayrex.git.springhandle.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class ConfigBeans extends WebMvcConfigurerAdapter {

    @Bean
    public UserInfoHandleResolver userInfoHandleResolver() {
        return new UserInfoHandleResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(this.userInfoHandleResolver());
    }

    @Bean
    @ConditionalOnClass(MybatisAutoConfiguration.class)
    public UpdatePlugin updatePlugin() {
        return new UpdatePlugin();
    }
}
