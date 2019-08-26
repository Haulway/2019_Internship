package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("用户实例")
public class User {
    @ApiModelProperty("用户姓名")
    private String Name;
    @ApiModelProperty("用户密码")
    private String Password;
    @ApiModelProperty("电话")
    private long Tel;
    @ApiModelProperty("住址")
    private String Address;
    @ApiModelProperty("年龄")
    private int Age;
    @ApiModelProperty("性别")
    private boolean Sex;

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Tel=" + Tel +
                ", Address='" + Address + '\'' +
                ", Age=" + Age +
                ", Sex=" + Sex +
                ", Identification=" + Identification +
                ", Search_History='" + Search_History + '\'' +
                ", Purchase_History='" + Purchase_History + '\'' +
                ", Cart_History='" + Cart_History + '\'' +
                ", Like_History='" + Like_History + '\'' +
                ", Order_History='" + Order_History + '\'' +
                '}';
    }

    @ApiModelProperty("身份识别符")
    private int Identification;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getTel() {
        return Tel;
    }

    public void setTel(long tel) {
        Tel = tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public int getIdentification() {
        return Identification;
    }

    public void setIdentification(int identification) {
        Identification = identification;
    }

    public String getSearch_History() {
        return Search_History;
    }

    public void setSearch_History(String search_History) {
        Search_History = search_History;
    }

    public String getPurchase_History() {
        return Purchase_History;
    }

    public void setPurchase_History(String purchase_History) {
        Purchase_History = purchase_History;
    }

    public String getCart_History() {
        return Cart_History;
    }

    public void setCart_History(String cart_History) {
        Cart_History = cart_History;
    }

    public String getLike_History() {
        return Like_History;
    }

    public void setLike_History(String like_History) {
        Like_History = like_History;
    }

    public String getOrder_History() {
        return Order_History;
    }

    public void setOrder_History(String order_History) {
        Order_History = order_History;
    }

    @ApiModelProperty("搜索历史")
    private String Search_History;
    @ApiModelProperty("搜索历史")
    private String Purchase_History;
    @ApiModelProperty("购物车添加记录")
    private String Cart_History;
    @ApiModelProperty("喜欢清单")
    private String Like_History;
    @ApiModelProperty("订单历史")
    private String Order_History;

}
