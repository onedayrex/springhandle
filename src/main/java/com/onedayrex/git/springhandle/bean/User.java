package com.onedayrex.git.springhandle.bean;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 7262652399020428603L;

    private String userName;

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
