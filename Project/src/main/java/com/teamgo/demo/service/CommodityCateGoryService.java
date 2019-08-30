package com.teamgo.demo.service;

import com.teamgo.demo.entity.CommodityCategory;
import com.teamgo.demo.mapper.CommodityCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityCateGoryService {
    @Autowired
    CommodityCategoryMapper commoditycategorymapper;

    //新增类目
    public void NewCategory(CommodityCategory category){
        commoditycategorymapper.NewCategory(category);
    }
}
