package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.User_old;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    public Integer loginReturnID(@Param("USERNAME")String username);
    public String loginReturnPassword(@Param("USERNAME")String username);
    public List<User_old> ListUser();
    public boolean register(@Param("username") String username,@Param("password") String password,@Param("ID") int ID);
}
