package com.teamgo.demo.service;

import com.teamgo.demo.entity.Commodity;
import com.teamgo.demo.entity.CommodityCategory;
import com.teamgo.demo.entity.Order;
import com.teamgo.demo.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;


    public List<Commodity> FuzzyQueryByName(String name) {
        return commodityMapper.FuzzyQueryByName(name);
    }
    public void insert(Commodity commodity) {
        commodityMapper.insert(commodity);

    }
    public List<Commodity> FindAllCommodity(){
        return	commodityMapper.AllCoomdity();
    }
    public int update(Commodity commodity){
        return commodityMapper.update(commodity);
    }
    public int delete(int id){
        return commodityMapper.delete(id);
    }
    //购买
    public void buy(String id,int volume)
    {
        int newstock=commodityMapper.getstock(id)-volume;
        int newvolumesell=commodityMapper.getvolumesell(id)+volume;
        commodityMapper.buyupdate(id,newstock,newvolumesell);
    }
    //由id查找一个商品
    public Commodity FindById(String id)
    {
        Commodity a=commodityMapper.FindById(id);

        return a;
    }
    //通过id获取价格
    public double GetPriceById(String id)
    {
        return commodityMapper.GetPriceById(id);
    }

}
