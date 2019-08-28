package com.teamgo.demo.controller;

import com.teamgo.demo.service.CommodityService;
import com.teamgo.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Ebehavior")
@Api(tags = "管理员行为")
public class EmployeeBehavior_Controller {
    @Autowired
    OrderService os;
    @Autowired
    CommodityService cs;

    @ApiOperation(value = "创建订单",notes = "传入订单的商品表和数量表，生成唯一订单号以及对应数据表，并写入数据库，计算价格")
    @GetMapping("/CreatOrder")
    @ResponseBody
    public String CreatOrder(@RequestParam(value = "商品id的list",required = true) List<String> orderlist,@RequestParam(value = "购买数量list",required = true) List<Integer> vollist)
    {
        /**
         * 生成订单号创建数据表
         * 得到订单商品表和数量
         * 计算价格
         */
        Date date = new Date();
        Timestamp t=new Timestamp(date.getTime());
        //生成订单号
        String Oid=String.valueOf(System.currentTimeMillis())+"teamgo";
        //创建数据表
        os.NewOrder(Oid);
        //插入列表数据
        for(int i=0;i<orderlist.size();i++)
        {
            os.insert(cs.FindById(orderlist.get(i)),vollist.get(i),Oid);
        }
        //计算价格
        double price=0;
        for(int i=0;i<orderlist.size();i++)
        {
            price=price+vollist.get(i)*cs.GetPriceById(orderlist.get(i));
        }
        return String.valueOf(price);
    }
}
