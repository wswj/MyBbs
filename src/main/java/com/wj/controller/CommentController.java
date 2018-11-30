package com.wj.controller;

import com.wj.pojo.Comment;
import com.wj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/commentController")
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    //通过帖子id获得帖子的评论信息
    @RequestMapping("/getCommentFid")
    public void getCommentByFid(int fid, Map<Object,Object> map){
        List<Comment> listComment=commentService.getCommentByFid(fid);
        map.put("listComment",listComment);
    }
    //添加评论
    @RequestMapping("/setComment")
    public String insertComment(Comment comment,Map<Object,Object> map){
        comment.setTime(new Date());
        commentService.setComment(comment);
        return "redirect:/index.jsp";
    }
    //删除评论
    @RequestMapping("/deleteComment")
    public String deleteComment(@RequestParam("pid") int pid){
        System.out.println("评论id为"+pid);
        commentService.deleteByPid(pid);
        return "redirect:/userController/getMyself.do";
    }
//    public void getCommentByUserid(int userid,Map<Object,Object> map){
//        List<Comment> listComment=commentService.getCommentByUserid(userid);
//        map.put()
//    }
}
