package com.teamgo.demo.service;

import com.teamgo.demo.entity.Commodity;
import com.teamgo.demo.entity.Order;
import com.teamgo.demo.entity.OrderItem_DB;
import com.teamgo.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderMapper ordermapper;
    //生成新订单(建表)
    public void NewOrder(String id)
    {
        ordermapper.NewTable(id);
    }
    //插入记录
    public void insert(Commodity commodity,Integer volume,String orderid)
    {
        ordermapper.InsertOneOrderItem(commodity.getId(),volume,orderid);
    }
    //查询表名
    public List<String> SearchTableName(String name)
    {
        return ordermapper.listTableColumn(name);
    }
    //查询表中所有信息
    public List<OrderItem_DB> SearchAll(String name)
    {
        return ordermapper.searchAll(name);
    }

}
