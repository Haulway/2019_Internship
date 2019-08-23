package com.teamgo.demo.controller;


import com.teamgo.demo.entity.User;
import com.teamgo.demo.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class User_CRUD {
    @Autowired
    UserService user_service ;


    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String login()
    {
        return"/webLogin";
    }
    @RequestMapping(value = "/loginPage",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, HttpSession session, Map<String,Object> map)
    {

        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String type  = request.getParameter("identity");
        System.out.println(userName);


           if(userName.equals("")||password.equals(""))
           {
               map.put("msg","请输入用户名与密码");
               return "/webLogin";
           }
           else
           {    if(type == null)
               {   System.out.println("type==null");
               map.put("msg","请选择角色");
               return"/webLogin";
               }
               if(!user_service.isExist(userName))
               {
                   map.put("msg","您输入的用户名不存在");
                   return"/webLogin";
               }
               if(user_service.IfPasswordCorrect(userName,password)&&type.equals("管理员"))
               {
                   return "redirect:/managerIndex";
               }
               if(user_service.IfPasswordCorrect(userName,password)&&type.equals("售货员"))
               {
                   return"redirect:/saleManIndex";
               }


                   map.put("msg","输入密码错误");
                   return"/webLogin";

           }


    }
    @RequestMapping(value = "/managerIndex",method = {RequestMethod.GET,RequestMethod.POST})
    public String managerLoginIndex(HttpServletRequest request)
    {

        return"/managerText";
    }
    @RequestMapping(value = "/saleManIndex",method = {RequestMethod.POST,RequestMethod.GET})
    public String sakeManLoginIndex()
    {
        return"/saletext";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(User user){
        return user_service.register(user);
    }
}