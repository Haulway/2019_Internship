package com.teamgo.demo.entity;

public class Item {
    private int id;
    private int amount;
    private String itemname;
    private String brand;
    private String location;
    private float unitprice;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getitemname() {
        return itemname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unit_price) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "Item:" + id + " " + itemname + " " + amount + "pc(s)" + unitprice + "per item";
    }
}