package com.teamgo.demo.entity;

public class OrderItem_User {
    private String name;
    private double price;
    private Integer volume;

    public OrderItem_User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public OrderItem_User(String name, double price, Integer volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }
}
