package com.teamgo.demo.controller;


import com.teamgo.demo.entity.User;
import com.teamgo.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Api(tags = "用户控制器(web端)")
public class User_Controller {
    @Autowired
    UserService user_service;

    @ApiOperation("首页页面跳转")
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String login() {
        return "/webLogin";
    }

    @ApiOperation(value = "登陆操作", notes = "登录操作，判断用户名密码匹配，以及用户身份")
    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST})
    public String login(HttpServletRequest request, Map<String, Object> map) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String type = request.getParameter("identity");
        Integer identity;

        if (type.equals("管理员")) identity = 0;
        else identity = 1;
        User user = new User(identity, name, password, null, null, null, null, null);
        System.out.println(user);
        if (name.equals("") || password.equals("")) {
            map.put("msg", "请输入用户名与密码");
            return "/webLogin";
        } else {
            if (type == null) {
                System.out.println("type==null");
                map.put("msg", "请选择身份");
                return "/webLogin";
            }
            if (!user_service.isExist_web(name)) {
                System.out.println(name + "exist");
                map.put("msg", "您输入的用户名不存在");
                return "/webLogin";
            }
            if (user_service.IfPasswordCorrect(new User(identity, user.getName(), user.getPassword(), null, null, null, null, true || false))
                    || (user_service.IfPasswordCorrect(new User(identity, null, user.getPassword(), null, null, null, user.getID(), true || false)) && type.equals("管理员"))) {
                return "redirect:/managerIndex";
            }
            if (user_service.IfPasswordCorrect(new User(identity, user.getName(), user.getPassword(), null, null, null, null, true || false))
                    || (user_service.IfPasswordCorrect(new User(identity, null, user.getPassword(), null, null, null, user.getID(), true || false))) && type.equals("售货员")) {
                return "redirect:/saleManIndex";
            }
            map.put("msg", "输入用户名密码错误");
            return "/webLogin";
        }
    }

    @ApiOperation(value = "跳转到管理员页面", notes = "若Id==0，跳转到管理员页面")
    @RequestMapping(value = "/managerIndex", method = {RequestMethod.GET})
    public String managerLoginIndex(HttpServletRequest request) {
        return "/administrator1";
    }

    @ApiOperation(value = "跳转到售货员页面", notes = "若Id==1，跳转到售货员页面")
    @RequestMapping(value = "/saleManIndex", method = {RequestMethod.GET})
    public String sakeManLoginIndex() {
        return "/cashier1";
    }
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public boolean register(String username, String password, int ID){
//        return user_service.register(username, password, ID);
//    }
}