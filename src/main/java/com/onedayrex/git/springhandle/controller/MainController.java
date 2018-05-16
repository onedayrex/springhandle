package com.onedayrex.git.springhandle.controller;

import com.onedayrex.git.springhandle.bean.User;
import com.onedayrex.git.springhandle.bean.UserReq;
import com.onedayrex.git.springhandle.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 字段验证
     * @param user
     * @return
     */
    @RequestMapping(value = "/validUser",method = RequestMethod.POST)
    public Object validUser(@RequestBody @Validated UserReq user) {
        return user;
    }
}
