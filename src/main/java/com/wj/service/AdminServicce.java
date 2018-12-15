package com.wj.service;

import com.wj.mapper.AdminMapper;
import com.wj.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicce {
    @Autowired
    AdminMapper adminMapper;
    //管理员登录查询
    public Admin adminLogin(Admin admin){
        return adminMapper.selectAdmin(admin);
    }
}
