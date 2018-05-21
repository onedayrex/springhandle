package com.onedayrex.git.springhandle.common.mapper;

import com.onedayrex.git.springhandle.common.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Insert(value = "insert into user_info(user_name,pass_word) values (#{userName},#{passWord} )")
    void insert(User user);

    void insertList(@Param("userList") List<User> userList);
}
