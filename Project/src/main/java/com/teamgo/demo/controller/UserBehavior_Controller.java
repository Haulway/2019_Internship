package com.teamgo.demo.controller;

import com.teamgo.demo.entity.User_Behavior;
import com.teamgo.demo.service.BehaviorService;
import com.teamgo.demo.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.*;

@Api("用户行为控制器")
@Controller
@RequestMapping("/Ubehavior")
public class UserBehavior_Controller {

    @Autowired
    BehaviorService bs;
    @Autowired
    CommodityService cs;
    @ApiOperation("购买")
    @GetMapping("/buy")
    @ResponseBody
    public String buy(String user_id,String commodity_id,int volume)
    {
        //向用户行为记录表中添加一条记录
        Date date = new Date();
        Timestamp t=new Timestamp(date.getTime());
        String str=String.valueOf(System.currentTimeMillis());
        System.out.println(str);
        bs.insert_behavior_record(new User_Behavior(
                user_id,
                commodity_id,
                5,
                t));
        //修改商店财务数据库销售额
        //修改商品库存，销量
        cs.buy(commodity_id,volume);
        return "购买成功";
    }
    @ApiOperation("查询自己的购买记录")
    @GetMapping("/SerchPurchase")
    @ResponseBody
    public List<User_Behavior> SerchPurchase(String UserId,int days)
    {
        //查询用户所有购买记录
        //按时间筛选

    }


}
