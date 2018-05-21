package com.onedayrex.git.springhandle.common.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class UserReq implements Serializable {
    private static final long serialVersionUID = -100922656053123607L;


    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Pattern(regexp = "^[1-9]\\d*$",message = "请输入数字")
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
