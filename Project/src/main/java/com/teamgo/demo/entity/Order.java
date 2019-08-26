package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("订单实体")
public class Order {
    @ApiModelProperty("对应表名")
    private long Id;

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", Buyer_Id=" + Buyer_Id +
                ", volume_of_trade=" + volume_of_trade +
                ", Creat_Time=" + Creat_Time +
                '}';
    }

    @ApiModelProperty("买家ID")
    private int Buyer_Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getBuyer_Id() {
        return Buyer_Id;
    }

    public void setBuyer_Id(int buyer_Id) {
        Buyer_Id = buyer_Id;
    }

    public double getVolume_of_trade() {
        return volume_of_trade;
    }

    public void setVolume_of_trade(double volume_of_trade) {
        this.volume_of_trade = volume_of_trade;
    }

    public Date getCreat_Time() {
        return Creat_Time;
    }

    public void setCreat_Time(Date creat_Time) {
        Creat_Time = creat_Time;
    }

    @ApiModelProperty("交易额")
    private double volume_of_trade;
    @ApiModelProperty("创建订单时间")
    private Date Creat_Time;

}
