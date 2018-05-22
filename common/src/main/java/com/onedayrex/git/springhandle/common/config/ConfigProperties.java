package com.onedayrex.git.springhandle.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "${properties.file:classpath:config.properties}")
public class ConfigProperties {
}
