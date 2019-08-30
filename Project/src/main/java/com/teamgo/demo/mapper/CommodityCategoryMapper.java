package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.CommodityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "CommodityCategoryMapper")
public interface CommodityCategoryMapper {
    //
    void NewCategory(@Param("category") CommodityCategory category);
}
