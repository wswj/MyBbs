package com.wj.mapper;

import com.wj.pojo.User;
import com.wj.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);
   //用户登录
    User dluSelect(User user);
    //注册查询用户名是否可用
    User loginSelect(User user);
    //注册添加用户
    int insert(User record);
    //修改登录信息包括用户名，密码和邮箱
    int updateSetUp(User user);
    //按userid查询用户信息
    User selectByUserId(int userid);
    //编辑个人资料
    int updateUser(User user);
    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userid);



    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}