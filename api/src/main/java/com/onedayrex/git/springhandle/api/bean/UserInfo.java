package com.onedayrex.git.springhandle.api.bean;

public class UserInfo {

    private String userName;

    private String password;

    public static class Builder{
        private  String userName;
        private  String password;

        public Builder() {
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }

    public UserInfo(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
