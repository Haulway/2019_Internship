package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class controller {

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String login()
    {
        return"/formalLogin";
    }
    @RequestMapping(value = "/loginPage",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, HttpSession session, Map<String,Object> map)
    {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String type  = request.getParameter("identity");

        String judge = "false";
       // session.setAttribute("tname",userName);
        if(userName.equals("刘昌镐")&&type.equals("管理员"))
        {
            return "redirect:/managerIndex";
        }
        else if(userName.equals("刘昌镐")&&type.equals("售货员"))
        {
            return "redirect:/saleManIndex";
        }

        else
        {
            if(userName .equals(""))
            {
                map.put("msg","请输入用户名");
                return"/formalLogin";
            }else {
                map.put("msg", "用户名密码错误");
                System.out.println("1");

                return "/formalLogin";
            }
        }

    }
   @RequestMapping(value = "/managerIndex",method = {RequestMethod.GET,RequestMethod.POST})
   public String managerLoginIndex(HttpServletRequest request)
    {   request.setAttribute("name","刘昌镐");
        return"/managerText";
    }
    @RequestMapping(value = "/saleManIndex",method = {RequestMethod.POST,RequestMethod.GET})
    public String sakeManLoginIndex()
    {
        return"/saletext";
    }

}
