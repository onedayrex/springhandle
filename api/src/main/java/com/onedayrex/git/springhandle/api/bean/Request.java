package com.onedayrex.git.springhandle.api.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Request<T> implements Serializable {
    private static final long serialVersionUID = -113161719365464399L;

    @NotEmpty(message = "requestId不能为空")
    private String requestId;

    @Valid
    @NotNull
    private T obj;
}
