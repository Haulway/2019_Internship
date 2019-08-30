package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.OrderItem_DB;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "OrderMapper")
public interface OrderMapper {
    //数据库中创建新订单的表
    void NewTable (@Param("id") String orderid);
    //插入一条订单数据（商品id，数量，订单id）
    void InsertOneOrderItem(@Param("commodity_ID") String id,@Param("volume") Integer volume,@Param("OrderId") String orderid);
    //查询数据库中的表名
    List<String> listTableColumn(String tableName);
    //查询表中数据
    List<OrderItem_DB> searchAll(@Param("orderid") String orderid);

}
