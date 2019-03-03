package com.wj.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//向服务器添加cookie实现记住登录密码
public class AddCookie extends HttpServlet {
    public void addCookie(String str, HttpServletResponse response){
        Cookie cookie=null;
        try {
             cookie=new Cookie("loginInfo",URLEncoder.encode(str,"UTF-8"));
             cookie.setPath("/");
             cookie.setMaxAge(24*60*60);
        } catch (UnsupportedEncodingException e) {
            System.out.println("编码异常");
        }
        response.addCookie(cookie);
    }
}
