package com.kwanhon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {
    /**
     * 账户设置
     * @return
     */
    @RequestMapping(path = "/account",method = RequestMethod.GET)
    public String account(){
        return "/config/account.html";
    }

    /**
     * 系统设置
     * @return
     */
    @RequestMapping(path = "/system",method = RequestMethod.GET)
    public String system(){
        return "/config/system.html";
    }
}
