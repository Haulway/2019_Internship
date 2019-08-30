package com.teamgo.demo.service;

import com.teamgo.demo.entity.User;
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
    //通过用户名返回密码？
    public String loginReturnPassword(String name){
        return userMapper.loginReturnPassword(name);
    }
    //通过用户名返回身份识别符
    public Integer loginReturnIdentity(String name){
        return userMapper.loginReturnidentity(name);
    }
    //判断用户是否已经存在
    public boolean isExist(String name){
        String passwordFromDB = loginReturnPassword(name);
        if(passwordFromDB == null){
            return false;
        }
        else{
            Integer IDFromDB = loginReturnIdentity(name);
            if((IDFromDB !=2) && (IDFromDB!=null)){
                System.out.println("IDFromDB=="+IDFromDB);
                return false;
            }
            else return true;
        }
    }
    //再微信端判断用户是否已经存在
    public boolean isExist_web(String name) {
        String passwordFromDB = loginReturnPassword(name);
        if(passwordFromDB == null) {
            System.out.println("passwordFromDB=="+passwordFromDB);
            return false;
        }else return true;
    }
    //密码是否正确
    public boolean IfPasswordCorrect(User user) {
        String passwordFromDB = loginReturnPassword(user.getName());
        Integer IdFromDB = loginReturnIdentity(user.getName());
        if((user.getPassword().equals(passwordFromDB))&&(user.getIdentity()==IdFromDB)) return true;
        else return false;
    }
    //注册
    public void register(User user) {

        User Myuser=new User(2,user.getName(),user.getPassword(),null,null,null,user.getID(),null);
        userMapper.register(Myuser);
        userMapper.WishList("Cart"+user.getID());
//        return true;
    }
    public int updateInfo(User user){
        return userMapper.updateInfo(user);
    }





}
