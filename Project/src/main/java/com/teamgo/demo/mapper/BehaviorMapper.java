package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.User_Behavior;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BehaviorMapper")
public interface BehaviorMapper {
    void insert_behavior_record(@Param("behavior") User_Behavior behavior);
    List<User_Behavior> FindAll();
    List<User_Behavior> FindUserBuy(@Param("ID") String id,@Param("Behavior") int behavior);
}
