package com.teamgo.demo.service;

import com.teamgo.demo.entity.Item;
import com.teamgo.demo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    public List<Item> findByName(String name) {
        return itemMapper.findItemByName(name);
    }
    public Item insert(Item item) {
        itemMapper.insert(item);
        return item;
    }
    public List<Item> ListItem(){
        return	itemMapper.ListItem();
    }
    public int update(Item item){
        return itemMapper.update(item);
    }
    public int delete(int id){
        return itemMapper.delete(id);
    }
}
