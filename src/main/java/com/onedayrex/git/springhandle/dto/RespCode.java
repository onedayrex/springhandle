package com.onedayrex.git.springhandle.dto;

import com.alibaba.fastjson.JSON;
import com.onedayrex.git.springhandle.constant.ConstantCode;

import java.io.Serializable;

public class RespCode implements Serializable {
    private static final long serialVersionUID = 4549994944568004023L;

    private String respCode;

    private String errorMsg;

    private String body;

    public RespCode() {
    }

    public RespCode(Object t) {
        this.respCode = ConstantCode.SUCCESS_CODE;
        this.body = JSON.toJSONString(t);
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
