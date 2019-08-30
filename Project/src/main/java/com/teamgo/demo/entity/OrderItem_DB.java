package com.teamgo.demo.entity;

public class OrderItem_DB {
    String commodity_id;
    Integer volume;

    public OrderItem_DB() {
    }

    public OrderItem_DB(String id, Integer volume) {
        this.commodity_id = id;
        this.volume = volume;
    }

    public String getId() {
        return commodity_id;
    }

    public void setId(String id) {
        this.commodity_id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
