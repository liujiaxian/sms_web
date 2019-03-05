package com.kwanhon.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kwanhon.common.remote.ApiResponse;
import com.kwanhon.common.remote.HttpServiceCaller;
import com.kwanhon.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doaim on 2017/4/25.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String index(){
        return "index.html";
    }
}
