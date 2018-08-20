package com.onedayrex.git.springhandle.api.controller;

import com.onedayrex.git.springhandle.common.annotation.PrintBean;
import com.onedayrex.git.springhandle.common.bean.User;
import com.onedayrex.git.springhandle.common.bean.UserReq;
import com.onedayrex.git.springhandle.common.mapper.UserInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@Api(value = "主页api")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Value("${db.host}")
    private String dbHost;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApplicationContext context;

    @RequestMapping("/index")
    @PrintBean(name = "MainController")
    public Object index(User user) {
        return user;
    }

    @RequestMapping("/add")
    public Object add(User user) {
        new Thread(() -> {
            while (true) {
                List<User> userList = new ArrayList<>();
                for (int i = 0; i < 5000; i++) {
                    userList.add(user);
                }
                userInfoMapper.insertList(userList);
                logger.info("==>insert into table");
            }
        }).start();
        return "OK";
    }

    /**
     * 字段验证
     * @param user
     * @return
     */
    @PostMapping(value = "/validUser")
    @ApiOperation("字段验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",required = true),
            @ApiImplicitParam(name = "passWord",required = true)
    })
    public Object validUser(@RequestBody @Validated UserReq user) {
        return user;
    }

    @RequestMapping("/thr")
    public Object thr() {
        throw new RuntimeException();
    }

    @RequestMapping("/properties")
    public Object properties() {
        return dbHost;
    }

    @RequestMapping("/resttemplate")
    public Object restTemplate() {
        ResponseEntity<String> resp = restTemplate.getForEntity("http://www.baidu.com", String.class);
        ((MainController) AopContext.currentProxy()).streamApi();
        return resp.getBody().toString();
    }

    @RequestMapping(value = "/streamapi")
    @Transactional(rollbackFor = Exception.class)
    public Object streamApi() {
        List<Integer> collect = Stream.of(1, 4, 5, 3, 5, 6, 32, 8, 89).filter(data -> data > 3).collect(Collectors.toList());
        User user = new User();
        user.setUserName("cssfs");
        user.setPassWord("wwwwww");
        userInfoMapper.insert(user);
        if ("1".equals("1")) {
            throw new RuntimeException("xxxxx");
        }
        return collect;
    }
}
