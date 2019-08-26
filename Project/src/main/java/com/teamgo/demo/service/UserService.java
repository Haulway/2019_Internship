package com.teamgo.demo.service;

import com.teamgo.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String loginReturnPassword(String name) {
       return userMapper.loginReturnPassword(name);
    }

    public Integer loginReturnID(String name){
        return userMapper.loginReturnID(name);
    }

    public boolean isExist(String name) {
        String passwordFromDB = loginReturnPassword(name);
        if(passwordFromDB == null) {
            System.out.println("passwordFromDB=="+passwordFromDB);
            return false;}
        else{   Integer IDFromDB = loginReturnID(name);
            if(IDFromDB !=2&&IDFromDB!=null) {
                System.out.println("IDFromDB=="+IDFromDB);
                return false;
            }
            else return true;
        }
    }

    public boolean isExist_web(String name) {
        String passwordFromDB = loginReturnPassword(name);
        if(passwordFromDB == null) {
            System.out.println("passwordFromDB=="+passwordFromDB);
            return false;}


        else return true;
    }


    public boolean IfPasswordCorrect(String name,String password,int tempID) {
        String passwordFromDB = loginReturnPassword(name);
        Integer IdFromDB = loginReturnID(name);

        if(password.equals(passwordFromDB)&&tempID==IdFromDB) return true;
        else return false;
    }

    public boolean register(String username, String password, int ID) {
        System.out.println(userMapper.register(username,password,ID));
        return true;
    }
}
