package com.onedayrex.git.springhandle.api.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 4427342131928093546L;

    @NotEmpty(message = "订单号不能为空")
    private String orderNo;

    @NotEmpty(message = "商品名称不能为空")
    private String goodsName;
}
