package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Date;

@ApiModel("行为实体")
public class User_Behavior {
    @ApiModelProperty(value = "行为执行者")
    private String Actor;
    @ApiModelProperty(value = "对象商品")
    private String Commodity;
    @ApiModelProperty(value = "行为")
    private int Behavior;
    @ApiModelProperty(value = "时间戳")
    private Timestamp Timestamp;

    public User_Behavior(String actor, String commodity, int behavior, java.sql.Timestamp timestamp) {
        Actor = actor;
        Commodity = commodity;
        Behavior = behavior;
        Timestamp = timestamp;
    }
    public User_Behavior()
    {}

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }

    public String getCommodity() {
        return Commodity;
    }

    public void setCommodity(String commodity) {
        Commodity = commodity;
    }

    public int getBehavior() {
        return Behavior;
    }

    public void setBehavior(int behavior) {
        Behavior = behavior;
    }

    public java.sql.Timestamp getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        Timestamp = timestamp;
    }
}
