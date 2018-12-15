package com.wj.controller;

import com.wj.pojo.Admin;
import com.wj.service.AdminServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@RequestMapping("/adminController")
@SessionAttributes(value = "adminList")
public class AdminController {
    @Autowired
    AdminServicce adminServicce;
    @Autowired
    PlateController plateController;
    @Autowired
    UserController userController;
    //用户登录
    @RequestMapping("/getLogin")
    public String Login(Admin admin, Map<Object,Object> map){
        Admin admin1=adminServicce.adminLogin(admin);
        System.out.println("用户名为"+admin1.getAname());
        if(admin1.getAname()!=null){
            map.put("adminList",admin1);
            plateController.getAllPlate(map);
            userController.getAllUser(map);
            return "redirect:/admin/index.jsp";
        }else {
            return "redirect:/admin/index.jsp";
        }
    }
    //管理员退出
    @RequestMapping("/adminExit")
    public String admiExit(Map<Object,Object> map){
        map.put("adminList","");
        return "redirect:/admin/index.jsp";
    }
}
