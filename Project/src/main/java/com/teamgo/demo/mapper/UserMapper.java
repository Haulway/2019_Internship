package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    public Integer loginReturnidentity(@Param("name")String Name);
    public String loginReturnPassword(@Param("name")String Name);
    public List<User> ListUser();
    public void register(@Param("user") User user);
    public int updateInfo(User user);
}
