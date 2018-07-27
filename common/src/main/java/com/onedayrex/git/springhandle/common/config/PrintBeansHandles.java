package com.onedayrex.git.springhandle.common.config;


import cn.hutool.core.util.ReflectUtil;
import com.alibaba.fastjson.JSON;
import com.onedayrex.git.springhandle.common.annotation.PrintBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PrintBeansHandles implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(PrintBeansHandles.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectUtil.getMethods(bean.getClass());
        if (methods != null && methods.length > 0) {
            for (int i = 0; i < methods.length; i++) {
                PrintBean annotation = methods[i].getAnnotation(PrintBean.class);
                if (annotation != null) {
                    logger.info("print Annotation==>[{}],bean properties[{}]", annotation.name(), JSON.toJSONString(bean));
                }
            }
        }
        return bean;
    }
}
