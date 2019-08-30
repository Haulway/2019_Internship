package com.teamgo.demo.controller;

import com.teamgo.demo.entity.*;
import com.teamgo.demo.service.BehaviorService;
import com.teamgo.demo.service.CommodityCateGoryService;
import com.teamgo.demo.service.CommodityService;
import com.teamgo.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Ebehavior")
@Api(tags = "管理员行为")
public class EmployeeBehavior_Controller {
    @Autowired
    OrderService os;
    @Autowired
    CommodityService cs;
    @Autowired
    CommodityCateGoryService ccs;
    @Autowired
    BehaviorService bs;
    @ApiOperation("订单输入页面跳转")
    @PostMapping("/toOrder")
    public String ToOrder()
    {
        return "/creatorder";
    }
    @ApiOperation(value = "创建订单并结算",notes = "传入订单的商品表和数量表，生成唯一订单号以及对应数据表，并写入数据库，计算价格")
    @GetMapping("/CreatOrder")
    @ResponseBody
    public String CreatOrder(@RequestParam(value = "商品id的list",required = true) List<String> orderlist,@RequestParam(value = "购买数量list",required = true) List<Integer> vollist,
                             String user_id)
    {
        /**
         * 生成订单号创建数据表
         * 得到订单商品表和数量
         * 计算价格
         */

        Date date = new Date();
        Timestamp t=new Timestamp(date.getTime());
        SimpleDateFormat ordertime=new SimpleDateFormat("yyyyMMddhhmm");
        //生成订单号
        String Oid=ordertime.format(date)+"teamgo"+user_id;

        //创建数据表
        os.NewOrder(Oid);
        //插入列表数据
        for(int i=0;i<orderlist.size();i++)
        {
            //插入订单表
            os.insert(cs.FindById(orderlist.get(i)),vollist.get(i),Oid);
            //添加购买记录
            bs.insert_behavior_record(new User_Behavior(
                    user_id,
                    orderlist.get(i),
                    5,
                    t));
            //修改商店财务数据库销售额
            //修改商品库存，销量
            cs.buy(orderlist.get(i),vollist.get(i));
        }
        //计算价格
        double price=0;
        for(int i=0;i<orderlist.size();i++)
        {
            price=price+vollist.get(i)*cs.GetPriceById(orderlist.get(i));
        }


        return String.valueOf(price);
    }

    @PostMapping("/newcommodity")
    @ResponseBody
    @ApiOperation("新增商品")
    public String newconnodity(Commodity commodity)
    {
        cs.insert(commodity);
        return "成功增加商品："+commodity.toString();
    }

    @PostMapping("/newcategory")
    @ResponseBody
    @ApiOperation("新增类目")
    public String newcategory(CommodityCategory category)
    {
        ccs.NewCategory(category);
        return "新增类目成功"+category.toString();
    }

    @GetMapping("/SearchOrderByID")
    @ApiOperation("根据id查询订单")
    @ResponseBody
    public Order SearchOrderByID(String id) throws ParseException {
        /**
         * 根据id查表
         * 表转化为订单
         */
        double price=0;
        Order currentorder =new Order();
        String userid=id.substring(17);
        currentorder.setBuyer_Id(userid);
        currentorder.setId(id);
        List<OrderItem_DB> currenttable=os.SearchAll(id);
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
        String time=id.substring(0,12);
        System.out.println(time);
        Date c_time;
        c_time=timestr.parse(time);
        System.out.println(c_time);
        Timestamp Create_time=new Timestamp(c_time.getTime());
        System.out.println(Create_time);
        currentorder.setCreat_Time(Create_time);
        //*****************************************************************************
        return currentorder;
    }
}
