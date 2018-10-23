package com.onedayrex.git.springhandle.api.bean;

import com.alibaba.fastjson.JSON;
import org.junit.Test;


public class UserInfoTest {

    @Test
    public void builder() {
        UserInfo userInfo = new UserInfo.Builder().setUserName("tom").setPassword("12345").build();
        System.out.println(JSON.toJSONString(userInfo));
    }

}