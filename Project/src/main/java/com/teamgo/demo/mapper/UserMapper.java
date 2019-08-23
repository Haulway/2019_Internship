package com.teamgo.demo.mapper;

import com.teamgo.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    public String login(@Param("USERNAME")String username );
    public List<User> ListUser();
    public int register(User user);
}
