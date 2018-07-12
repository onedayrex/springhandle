package com.onedayrex.git.springhandle.common.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class LoggerFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        StringBuilder sb = new StringBuilder();
        String method = req.getMethod();
        if ("POST".equals(method)) {
            BodyHttpServletRequest bodyHttpServletRequest = new BodyHttpServletRequest(req);
            chain.doFilter(bodyHttpServletRequest, response);
            String bodyString = BodyHttpServletRequest.getBodyString(bodyHttpServletRequest);
            sb.append(bodyString);
        }else {
            for (Map.Entry<String, String[]> entry : entries) {
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            if (StringUtils.isNotBlank(sb)) {
                sb.deleteCharAt(sb.length() - 1);
            }
            chain.doFilter(request,response);
        }
        logger.info("[{}] param==>[{}]",req.getRequestURL(),sb);
    }

    @Override
    public void destroy() {

    }
}
