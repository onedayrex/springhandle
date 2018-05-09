package com.onedayrex.git.springhandle.controller;

import com.onedayrex.git.springhandle.bean.User;
import com.onedayrex.git.springhandle.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/index")
    public Object index(User user) {
        return user;
    }

    @RequestMapping("/add")
    public Object add(User user) {
        userInfoMapper.insert(user);
        return "OK";
    }
}
