package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



@Controller
public class controller {

    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String login()
    {
        return"/cashier1";
    }
    @RequestMapping(value = "loginRequest",method = {RequestMethod.GET,RequestMethod.POST})

    public Map<String,Object>respondLoginRequest(String userName,String password)
    {   System.out.println("微信小程序调用端口");
        System.out.println("userName == "+userName );
        System.out.println("password == " + password);
        Map<String,Object>map = new HashMap<String,Object>();
        if(userName.equals("abc")&&password.equals("123"))
        {    map.put("data","true");

            return map;
        }
        else map.put("data","false");
        System.out.println("false");
        return map;
    }
//    @RequestMapping(value = "registerRequest",method = {RequestMethod.GET,RequestMethod.POST})
//    public Map<String,Object>respondRegisterRequest(String userName,String password)
//    {
//        System.out.println(userName);
//        System.out.println(password);
//        Map<String,Object>map = new HashMap<>();
//        if(userName.equals("123"))
//        {
//            map.put("msg","exist");
//        }else
//        {
//            map.put("msg","success");
//        }
//        return map;
//    }


   @RequestMapping(value = "/loginPage",method = {RequestMethod.GET,RequestMethod.POST})


    public String login(HttpServletRequest request, Map<String,Object> map)
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String ID = request.getParameter("ID");


        String judge = "false";

        if(userName.equals("刘昌镐"))
        {   map.put("ID","1234567");
            map.put("counts","12000");
            map.put("credit","良好");
            map.put("level","铂金");
            return "/testCashier";
        }
//        else if(userName.equals("刘昌镐")&&type.equals("售货员"))
//        {   map.put("ID","123456");
//            return "/login";
//        }

        else
        {
            if(userName .equals(""))
            {
                map.put("msg","请输入用户名");
                return"/login";
            }else {
                map.put("msg", "用户名密码错误");


                return "/login";
            }
        }


    }
   @RequestMapping(value = "/managerIndex",method = {RequestMethod.GET,RequestMethod.POST})
   public String managerLoginIndex(Map<String,Object> map)
    {
        return"/administrator1";
    }
    @RequestMapping(value = "/saleManIndex",method = {RequestMethod.POST,RequestMethod.GET})
    public String sakeManLoginIndex()
    {
        return"/cashier1";
    }
    
    @RequestMapping(value = "cashier",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> result( @RequestBody Map<String,Object> map)
    {
        ArrayList<String> goodsID = (ArrayList<String>) map.get("goodsID");
        ArrayList<String> goodsName = (ArrayList<String>)map.get("goodsName");
        ArrayList<String> counts = (ArrayList<String>)map.get("counts");
        ArrayList<String> cost = (ArrayList<String>)map.get("cost");
        if(goodsID == null)
        {
            System.out.println("error: NullPointer");
        }
        else {
            for (int i = 0; i < goodsID.size(); i++) {
                System.out.print(goodsID.get(i));
                System.out.print(goodsName.get(i));
                System.out.print(counts.get(i));
                System.out.print(cost.get(i));
                System.out.println("");
            }
        }
         Map<String,Object> returnMap =new HashMap<>();
        
         
                 
 
         returnMap.put("money",123);
         returnMap.put("time","2019-08-30-9:15");
        return returnMap;
    }

}
