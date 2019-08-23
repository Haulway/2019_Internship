package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "ItemMapper")
public interface ItemMapper {
    List<Item> findItemByName(String name);
    public List<Item> ListItem();
    public int insert(Item item);
    public int delete(int id);
    public int update(Item item);
}
