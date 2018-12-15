package com.wj.service;

import com.wj.mapper.UserMapper;
import com.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable {
    @Autowired
    UserMapper userMapper;
    //登录查询
    public User getUser(User user){
        return userMapper.dluSelect(user);
    }
    //注册查询用户名是否可用
    public User getUserName(User user){
        return userMapper.loginSelect(user);
    }
    //注册添加用户
    public void setUser(User user){
        userMapper.insert(user);
    }
    //修改用户信息包括用户名，登录密码，邮箱
    public void updateUser(User user){
        userMapper.updateSetUp(user);
    }
    //通过userid查询用户信息
    public User getUserById(int userid){
        return userMapper.selectByUserId(userid);
    }
    //编辑个人资料
    public void updateUserzhiliao(User user){
        userMapper.updateUser(user);
    }
    //无条件查询所有用户
    public List<User> getAllUser(){return userMapper.selectUser();}
    //删除用户
    public void deleteUser(int userid){userMapper.deleteUser(userid);}
}
