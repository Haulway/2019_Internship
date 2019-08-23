package com.teamgo.demo.service;

import com.teamgo.demo.entity.User;
import com.teamgo.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String login(String name) {

       String msg = userMapper.login(name);

        return msg;

    }
    public boolean isExist(String name)
    {
        String passwordFromDB = login(name);
        if(passwordFromDB == null)
        {
            return false;
        }else
        {
            return true;
        }
    }

    public boolean IfPasswordCorrect(String name,String password)
    {
        String passwordFromDB = login(name);

        if(password.equals(passwordFromDB))
        {

            return true;
        }
        else return false;
    }

    public User register(User user) {
        userMapper.register(user);
        return user;
    }

}
