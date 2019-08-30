package com.teamgo.demo.controller;

import com.teamgo.demo.entity.*;
import com.teamgo.demo.service.BehaviorService;
import com.teamgo.demo.service.CommodityService;
import com.teamgo.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags="用户行为")
@Controller
@RequestMapping("/Ubehavior")
public class UserBehavior_Controller {

    @Autowired
    BehaviorService bs;
    @Autowired
    CommodityService cs;
    @Autowired
    OrderService os;

    @ApiOperation(value = "查询自己的购买记录",notes = "查询指定用户在指定时间段内的购买记录")
    @GetMapping("/SerchPurchase")
    @ResponseBody
    public List<User_Behavior> SerchPurchase(String UserId,int days)
    {
        //查询用户所有购买记录
        //按时间筛选
        return bs.SearchPurchase(UserId, days);
    }
    @ApiOperation("查询自己的订单")
    @GetMapping("/SearchMyOrder")
    @ResponseBody
    public List<Order> searchmyorder(String userid) throws ParseException {
        /**
         * 查询表名为userid的订单表
         * for
         * 查询每一个订单表中的数据，并计算总价
         * new Order 添加到list
         * 返回list<order>
         */
        List<Order> result=new ArrayList<>();
        List<String> tablelist=os.SearchTableName(userid);
        //遍历订单表
        for(int i=0;i<tablelist.size();i++)
        {
            double price=0;
            Order currentorder =new Order();
            currentorder.setBuyer_Id(userid);
            currentorder.setId(tablelist.get(i));
            List<OrderItem_DB> currenttable=os.SearchAll(tablelist.get(i));
            List<OrderItem_User> UserOrder=new ArrayList<>();
            double total=0;
            //遍历当前订单
            for(int j=0;j<currenttable.size();j++)
            {
                //**********************把OrderItem_DB转化为OrderItem_User*************
                String name = cs.FindById(currenttable.get(j).getId()).getName();
                double currentprice =cs.FindById(currenttable.get(j).getId()).getPrice();
                Integer vol=currenttable.get(j).getVolume();
                //********************************************************************
                total+=currentprice*vol;
                OrderItem_User currentItem=new OrderItem_User(name,currentprice,vol);
                UserOrder.add(currentItem);
            }
            currentorder.setVolume_of_trade(total);
            currentorder.setCommodity_Order(UserOrder);
            //****************************时间格式转换**************************************
            SimpleDateFormat timestr=new SimpleDateFormat("yyyyMMddhhmm");
            String time=tablelist.get(i).substring(0,12);
            //System.out.println(time);
            Date c_time;
            c_time=timestr.parse(time);
           // System.out.println(c_time);
            Timestamp Create_time=new Timestamp(c_time.getTime());
            //System.out.println(Create_time);
            currentorder.setCreat_Time(Create_time);
            //*****************************************************************************
            result.add(currentorder);
        }
        return result;
    }
    @GetMapping("/fuzzyquery")
    @ApiOperation(value = "商品模糊查询",notes = "搜索出的商品，添加用户记录")
    @ResponseBody
    public List<Commodity> fuzzyquery(String key,String userid)
    {
        Date date = new Date();
        Timestamp t=new Timestamp(date.getTime());
        List<Commodity> commodity=cs.FuzzyQueryByName(key);
        for(int i=0;i<commodity.size();i++)
        {
            bs.insert_behavior_record(new User_Behavior(userid,commodity.get(i).getId(),2,t));
        }
        return commodity;
    }

    @ApiOperation("加入购物车")
    @PostMapping("/addCart")
    @ResponseBody
    public String addCart(Commodity commodity)
    {
        /**
         * 前端传入一个商品
         *
         */
        return "添加成功";
    }
}
