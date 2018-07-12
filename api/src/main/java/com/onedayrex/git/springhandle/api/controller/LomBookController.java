package com.onedayrex.git.springhandle.api.controller;

import com.onedayrex.git.springhandle.common.bean.BankInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LomBookController {

    @RequestMapping("/getLomBok")
    public Object getLomBok() {
        BankInfo bankInfo = new BankInfo();
        bankInfo.setBankNo("513123");
        bankInfo.setIdent("1234551");
        bankInfo.setPhone("121444");
        return bankInfo;
    }
}
