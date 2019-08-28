package com.teamgo.demo.controller;

import com.teamgo.demo.entity.User;
import com.teamgo.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户控制器（微信端）")
public class WX_Controller {
    @Autowired
    UserService user_service ;
    @ApiOperation(value = "登录请求")
    @RequestMapping(value = "loginRequest",method = {RequestMethod.GET})
    public Map<String,Object> respondLoginRequest(User user){
        Map<String,Object>map = new HashMap<String,Object>();
        user.setIdentity(2);
        if(user_service.IfPasswordCorrect(user)){
            map.put("data","true");
            return map;
        }
        else map.put("data","false");
        return map;
    }
    @ApiOperation("注册请求")
    @RequestMapping(value = "registerRequest",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiImplicitParam(name ="user",value = "用户实体")
    public Map<String,Object> respondRegisterRequest(User user) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        if (user_service.isExist(user.getName())) map1.put("msg", "exist");
        else{
            map1.put("msg","success");
            user.setIdentity(2);
            user_service.register(user);
        }
        return map1;
    }
}