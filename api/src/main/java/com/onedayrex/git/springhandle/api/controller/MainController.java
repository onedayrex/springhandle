package com.onedayrex.git.springhandle.api.controller;

import com.onedayrex.git.springhandle.common.bean.User;
import com.onedayrex.git.springhandle.common.bean.UserReq;
import com.onedayrex.git.springhandle.common.mapper.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Value("${db.host}")
    private String dbHost;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public Object index(User user) {
        return user;
    }

    @RequestMapping("/add")
    public Object add(User user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    List<User> userList = new ArrayList<>();
                    for (int i = 0; i < 5000; i++) {
                        userList.add(user);
                    }
                    userInfoMapper.insertList(userList);
                    logger.info("==>insert into table");
                }
            }
        }).start();
        return "OK";
    }

    /**
     * 字段验证
     * @param user
     * @return
     */
    @RequestMapping(value = "/validUser",method = RequestMethod.POST)
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
        return resp.getBody().toString();
    }
}
