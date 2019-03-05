package com.kwanhon.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public class ValidateController {
    public JSONObject userinfo;

    public JSONObject getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(JSONObject userinfo) {
        this.userinfo = userinfo;
    }

    @ModelAttribute
    public void IsLogin(HttpServletResponse res, HttpSession session, HttpServletRequest request){
        if(session.getAttribute("currentUser")==null){
            try {
                String  url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()+ request.getContextPath()  +  request.getServletPath();
                res.sendRedirect(request.getContextPath()+"/account/login?redirect="+ (URLEncoder.encode(url,"gb2312")));
            } catch (IOException e) {
                throw new RuntimeException("登录检验异常！"+e);
            }
        }else{
            userinfo = (JSONObject)session.getAttribute("currentUser");
        }
    }
}
