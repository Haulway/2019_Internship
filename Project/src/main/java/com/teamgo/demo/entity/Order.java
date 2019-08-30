package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;

import java.util.List;

@ApiModel("订单实体")
public class Order {
    @ApiModelProperty("订单号")
    private String Id;
    @ApiModelProperty("买家ID")
    private String Buyer_Id;
    @ApiModelProperty("交易额")
    private double volume_of_trade;
    @ApiModelProperty("创建订单时间")
    private Timestamp Creat_Time;
    @ApiModelProperty("订单商品表")
    private List<OrderItem_User> Commodity_Order;

    public Order(String id, String buyer_Id, double volume_of_trade,
                 Timestamp creat_Time, List<OrderItem_User> commodity_Order) {
        Id = id;
        Buyer_Id = buyer_Id;
        this.volume_of_trade = volume_of_trade;
        Creat_Time = creat_Time;
        Commodity_Order = commodity_Order;

    }

    public Order() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBuyer_Id() {
        return Buyer_Id;
    }

    public void setBuyer_Id(String buyer_Id) {
        Buyer_Id = buyer_Id;
    }

    public double getVolume_of_trade() {
        return volume_of_trade;
    }

    public void setVolume_of_trade(double volume_of_trade) {
        this.volume_of_trade = volume_of_trade;
    }

    public Timestamp getCreat_Time() {
        return Creat_Time;
    }

    public void setCreat_Time(Timestamp creat_Time) {
        Creat_Time = creat_Time;
    }

    public List<OrderItem_User> getCommodity_Order() {
        return Commodity_Order;
    }

    public void setCommodity_Order(List<OrderItem_User> commodity_Order) {
        Commodity_Order = commodity_Order;
    }
}
