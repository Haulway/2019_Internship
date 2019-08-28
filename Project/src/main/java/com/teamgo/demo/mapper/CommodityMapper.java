package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "ItemMapper")
public interface CommodityMapper {
    List<Commodity> FindCommodityByName(String name);
    public List<Commodity> AllCoomdity();
    public int insert(Commodity commodity);
    //删除id为id的商品
    public int delete(int id);
    //更新商品
    public int update(Commodity commodity);
    //修改商品库存和销量
    void buyupdate(@Param("id") String id,@Param("ns") int newstock,@Param("nvs") int newvolumesell);
    //获取库存量
    int getstock(String id);
    //获取销量
    int getvolumesell(String id);
    //通过id查找商品
    Commodity FindById(String id);
    //通过id查询价格
    double GetPriceById(String id);
}
