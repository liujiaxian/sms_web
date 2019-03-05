package com.kwanhon.controller;

import com.alibaba.fastjson.JSONObject;
import com.kwanhon.common.remote.ApiResponse;
import com.kwanhon.common.remote.HttpServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Doaim on 2017/4/25.
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    HttpServiceCaller serviceCaller;
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login(){
        return "/account/login.html";
    }

    @RequestMapping(path = "/postLoginValidate",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String postLoginValidate(@RequestParam String username, @RequestParam String password,HttpSession session) {
        Map<String,String> params = new HashMap<>();
        params.put("userName",username);
        params.put("password",password);
        ApiResponse apiResponse = serviceCaller.post("/user/get",params);

        JSONObject response = new JSONObject();
        response.put("success",false);
        response.put("errorMsg","用户名或密码错误");
        if(apiResponse.isSucceed()){
            JSONObject user = (JSONObject)apiResponse.getResponseData();
            if(user != null) {
                session.setAttribute("currentUser", user);
                response.put("success",true);
                response.put("errorMsg","登录成功");
            }
        }
        return response.toJSONString();
    }

    @RequestMapping(path = "/bindLogin",method = RequestMethod.GET)
    public String bindLogin(){
        return "/account/bindlogin.html";
    }

    @RequestMapping(path = "/loginPop",method = RequestMethod.GET)
    public String loginPop(){
        return "/account/loginpop.html";
    }


    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String register(){
        return "/account/register.html";
    }

    @RequestMapping(path = "/forgetPwd",method = RequestMethod.GET)
    public String forgetPwd(){
        return "/account/forgetpwd.html";
    }
}