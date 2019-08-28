package com.teamgo.demo.service;

import com.teamgo.demo.entity.User_Behavior;
import com.teamgo.demo.mapper.BehaviorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BehaviorService {
    @Autowired
    BehaviorMapper behaviorMapper;
    public void insert_behavior_record(User_Behavior ub)
    {
        behaviorMapper.insert_behavior_record(ub);
    }
    //返回所有商品
    public List<User_Behavior> FindAll(){
        return behaviorMapper.FindAll();
    }
    //返回对应用户的指定行为记录5为购买
    public List<User_Behavior> FindUserBuy(String id,int behavior)
    {
        return behaviorMapper.FindUserBuy(id, behavior);
    }

}
