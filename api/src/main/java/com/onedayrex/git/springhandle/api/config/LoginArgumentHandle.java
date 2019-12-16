package com.onedayrex.git.springhandle.api.config;

import com.onedayrex.git.springhandle.api.annotation.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class LoginArgumentHandle implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(LoginArgumentHandle.class);
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        logger.info("filter parameter");
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        logger.info("get token");
        String token = request.getHeader("token");
        return token;
    }
}
