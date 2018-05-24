package com.onedayrex.git.springhandle.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean<Filter> filter = new FilterRegistrationBean<>();
        filter.addUrlPatterns("/*");
        filter.setFilter(loggerFilter());
        return filter;
    }

    @Bean
    public LoggerFilter loggerFilter() {
        return new LoggerFilter();
    }
}
