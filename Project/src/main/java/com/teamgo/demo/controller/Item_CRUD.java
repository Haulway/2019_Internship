package com.teamgo.demo.controller;


import com.teamgo.demo.entity.Item;
import com.teamgo.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/Item_CRUD", method = { RequestMethod.GET, RequestMethod.POST })
public class Item_CRUD {

    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int item_id) {
//        System.out.println("====="+id);
        int result = itemService.delete(item_id);
        if (result >= 1) return "删除成功";
        else return "删除失败";
//        System.out.println("删除结束");
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Item item) {
        int result = itemService.update(item);
        if (result >= 1) return "修改成功";
        else return "修改失败";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Item insert(Item item){
        return itemService.insert(item);
    }
    @RequestMapping("/ListItem")
    @ResponseBody
    public List<Item> ListItem(){
        return itemService.ListItem();
    }
    @RequestMapping("/ListItemByName")
    @ResponseBody
    public List<Item> ListItemByName (String name){
        return itemService.findByName(name);
    }
}
