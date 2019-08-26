package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("商品类目实例")
public class CommodityCategory {

    @ApiModelProperty("类目名称")
    private String Name;
    @ApiModelProperty("类目编号")
    private int ID;
    @ApiModelProperty("类目描述")
    private  String Description;

    @Override
    public String toString() {
        return "CommodityCategory{" +
                "Name='" + Name + '\'' +
                ", ID=" + ID +
                ", Description='" + Description + '\'' +
                '}';
    }

    public CommodityCategory(String name, int ID, String description) {
        setName(name);
        setID(ID);
        setDescription(description);
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
