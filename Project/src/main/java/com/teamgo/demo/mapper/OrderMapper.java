package com.teamgo.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "OrderMapper")
public interface OrderMapper {
    //数据库中创建新订单的表
    void NewTable (@Param("id") String orderid);
    //插入一条订单数据（商品id，数量，订单id）
    void InsertOneOrderItem(@Param("commodity_ID") String id,@Param("volume") Integer volume,@Param("OrderId") String orderid);
}
