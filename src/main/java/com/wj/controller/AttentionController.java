package com.wj.controller;

import com.wj.pojo.Attention;
import com.wj.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/attentionController")
public class AttentionController {
    @Autowired
    AttentionService attentionService;
    //添加关注
    @RequestMapping("/setAttention")
    public String addAttention(Attention attention){
        attentionService.setAttention(attention);
        return "redirect:/index.jsp";
    }
    @RequestMapping("deleteAttention")
    public String deleteAttention(@RequestParam("gid") int gid){
        attentionService.deleteAttention(gid);

        return "redirect:/index.jsp";
    }
    @RequestMapping("/deleteAttentionMyself")
    public String deleteAttentionMyself(Attention attention){
        attentionService.deleteAttentionAtMyself(attention);
        return "redirect:/userController/getMyself.do";
    }

}
