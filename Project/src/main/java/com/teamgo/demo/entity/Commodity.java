package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



public class Commodity {

    @ApiModelProperty("商品名称")
    private String Name;
    @ApiModelProperty("商品编号")
    private String Id;
    @ApiModelProperty("商品类别")
    private int Category;
    @ApiModelProperty("商品描述")
    private String Description;
    @ApiModelProperty("商品价格")
    private double Price;
    @ApiModelProperty("商品库存量")
    private int Stock;
    @ApiModelProperty("商品销量")
    private int Volume_Of_Sell;
    @ApiModelProperty("货架位置")
    private String Location;
    @ApiModelProperty("商品图标")
    private String Icon;
    @ApiModelProperty("商品状态")
    private int Heat;
    @ApiModelProperty("商品评分")
    private float Point;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getVolume_Of_Sell() {
        return Volume_Of_Sell;
    }

    public void setVolume_Of_Sell(int volume_Of_Sell) {
        Volume_Of_Sell = volume_Of_Sell;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public int getHeat() {
        return Heat;
    }

    public void setHeat(int heat) {
        Heat = heat;
    }

    public float getPoint() {
        return Point;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "Name='" + Name + '\'' +
                ", Id=" + Id +
                ", Category=" + Category +
                ", Description='" + Description + '\'' +
                ", Price=" + Price +
                ", Stock=" + Stock +
                ", Volume_Of_Sell=" + Volume_Of_Sell +
                ", Location='" + Location + '\'' +
                ", Icon='" + Icon + '\'' +
                ", Heat=" + Heat +
                ", Point=" + Point +
                '}';
    }
    public Commodity()
    {

    }
    public Commodity(String name,int category,String id, String description, double price, int stock, int volume_Of_Sell, String location, String icon, int heat, float point) {
        Name = name;
        Id = id;
        Category = category;
        Description = description;
        Price = price;
        Stock = stock;
        Volume_Of_Sell = volume_Of_Sell;
        Location = location;
        Icon = icon;
        Heat = heat;
        Point = point;
    }

    public void setPoint(float point) {
        Point = point;
    }

}
