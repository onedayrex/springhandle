package com.onedayrex.git.springhandle.common.config;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("execution(* com.onedayrex.git.springhandle.controller.*.*(..))")
    public void execute() {
    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String rest = JSON.toJSONString(args);
        logger.info("param==>[{}]", rest);
    }

    @AfterThrowing(value = "execute()", throwing = "ex")
    public void exception(JoinPoint joinPoint, Throwable ex) {
        Object[] args = joinPoint.getArgs();
        String rest = JSON.toJSONString(args);
        logger.info("error param==>[{}]", rest);
        logger.error("error msg",ex);
    }
}
