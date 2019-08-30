package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("用户实例")
public class User {
    /**
     * 1.身份识别符：0为管理员，1为售货员，2为顾客
     * 2.用户名、密码：由用户注册得到
     * 3.电话、住址、年龄：默认为null
     * 4.ID：由系统自动生成六位数账号
     * 5.性别：默认为女
     */
    @ApiModelProperty("身份识别符")
    private Integer identity;
    @ApiModelProperty("用户名")
    private String Name;
    @ApiModelProperty("用户密码")
    private String Password;
    @ApiModelProperty("电话")
    private Integer Tel = null;

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

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

    public Integer getTel() {
        return Tel;
    }

    public void setTel(Integer tel) {
        Tel = tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Boolean isSex() {
        return Sex;
    }

    public void setSex(Boolean sex) {
        Sex = sex;
    }

    @ApiModelProperty("住址")
    private String Address;
    @ApiModelProperty("年龄")
    private Integer Age;
    @ApiModelProperty("ID")
    private String ID;
    @ApiModelProperty("性别")
    private Boolean Sex;


    public User(Integer identity, String name, String password, Integer tel, String address, Integer age, String ID, Boolean sex) {
        this.identity = identity;
        Name = name;
        Password = password;
        Tel = tel;
        Address = address;
        Age = age;
        this.ID = ID;
        Sex = sex;
    }
    public User(){}
    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Address='" + Address + '\'' +
                ", Age=" + Age +
                ", identity=" + identity +
                ", Sex=" + Sex +
                '}';
    }
}
