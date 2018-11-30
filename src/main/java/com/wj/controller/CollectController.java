package com.wj.controller;

import com.wj.pojo.Collect;
import com.wj.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/collectController")
public class CollectController {
    @Autowired
    CollectService collectService;
    @RequestMapping("setCollect")
    //添加收藏信息
    public String setCollect(Collect collect){
        collectService.setCollect(collect);
        return "redirect:/index.jsp";
    }
    //删除收藏信息
    @RequestMapping("deleteCollect")
    public String deleteCollect(@RequestParam("sid") int sid){
        collectService.deleteCollect(sid);
        return  "redirect:/index.jsp";
    }
    //删除收藏信息通过userid和fid
    @RequestMapping("/deleteCollectUseridAndFid")
    public String deleteCollectAtMyself(Collect collect){
        collectService.deleteCollectByUseridAndFid(collect);
        return "redirect:/userController/getMyself.do";
    }
}
