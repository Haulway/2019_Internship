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

    public String loginReturnPassword(String name){
        return userMapper.loginReturnPassword(name);
    }

    public Integer loginReturnIdentity(String name){
        return userMapper.loginReturnidentity(name);
    }

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
    public boolean isExist_web(String name) {
        String passwordFromDB = loginReturnPassword(name);
        if(passwordFromDB == null) {
            System.out.println("passwordFromDB=="+passwordFromDB);
            return false;
        }else return true;
    }

        public boolean IfPasswordCorrect(User user) {
        String passwordFromDB = loginReturnPassword(user.getName());
        Integer IdFromDB = loginReturnIdentity(user.getName());
        if((user.getPassword().equals(passwordFromDB))&&(user.getIdentity()==IdFromDB)) return true;
        else return false;
    }

    public void register(User user) {
        String id=String.valueOf(System.currentTimeMillis());
        User Myuser=new User(2,user.getName(),user.getPassword(),null,null,null,id,null);
        userMapper.register(Myuser);
//        return true;
    }
    public int updateInfo(User user){
        return userMapper.updateInfo(user);
    }
}
