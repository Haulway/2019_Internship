package com.teamgo.demo.service;

import com.teamgo.demo.entity.Commodity;
import com.teamgo.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper ordermapper;
    //生成新订单
    public void NewOrder(String id)
    {
        ordermapper.NewTable(id);
    }
    public void insert(Commodity commodity,Integer volume,String orderid)
    {
        ordermapper.InsertOneOrderItem(commodity.getId(),volume,orderid);
    }

}
