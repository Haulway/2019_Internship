package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import java.util.Map;

@ApiModel("订单实体")
public class Order {
    @ApiModelProperty("订单号")
    private long Id;
    @ApiModelProperty("买家ID")
    private int Buyer_Id;
    @ApiModelProperty("交易额")
    private double volume_of_trade;
    @ApiModelProperty("创建订单时间")
    private Date Creat_Time;
    @ApiModelProperty("订单商品表")
    private Map<Integer,Integer> Commodity_Order;
}
