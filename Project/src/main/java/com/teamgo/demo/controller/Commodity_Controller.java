package com.teamgo.demo.controller;


import com.teamgo.demo.entity.Commodity;
import com.teamgo.demo.service.CommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/Commodity_CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class Commodity_Controller {

    @Autowired
    private CommodityService commodityService;
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int Commodity_id) {
//        System.out.println("====="+id);
        int result = commodityService.delete(Commodity_id);
        if (result >= 1) return "删除成功";
        else return "删除失败";
//        System.out.println("删除结束");
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Commodity commodity) {
        int result = commodityService.update(commodity);
        if (result >= 1) return "修改成功";
        else return "修改失败";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Commodity insert(Commodity commodity){
        return commodityService.insert(commodity);
    }
    @RequestMapping("/ListCommodity")
    @ResponseBody
    public List<Commodity> ListCommodity(){
        return commodityService.FindAllCommodity();
    }
    @RequestMapping("/ListCommodityByName")
    @ApiOperation("查询")
    @ResponseBody
    public List<Commodity> FindByName (String name){
        return commodityService.findByName(name);
    }

    @RequestMapping("/findbyid")
    @ApiOperation("通过id查找")
    @ResponseBody
    public Commodity findbyid(String id)
    {
        return commodityService.FindById(id);
    }
}
