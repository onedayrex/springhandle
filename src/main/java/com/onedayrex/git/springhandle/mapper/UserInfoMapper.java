package com.onedayrex.git.springhandle.mapper;

import com.onedayrex.git.springhandle.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    @Insert(value = "insert into user_info(user_name,pass_word) values (#{userName},#{passWord} )")
    void insert(User user);
}
