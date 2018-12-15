package com.wj.controller;

import com.wj.pojo.*;
import com.wj.service.ArticleService;
import com.wj.service.AttentionService;
import com.wj.service.CollectService;
import com.wj.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
@SessionAttributes(value = {"plate"})
@Controller
@RequestMapping("/common")

public class Common {
    @Autowired
    PlateService plateService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleController articleController;
    @Autowired
    CommentController commentController;
    @Autowired
    AttentionService attentionService;
    @Autowired
    CollectService collectService;
    @Autowired
    PlateController plateController;
    @Autowired
    UserController userController;
    @RequestMapping("/getAll")
    public String getAll(Map<Object,Object> map,Map<Object,Object> map2){
        articleController.getArticle(map);
        List<Article> listArticle=(List<Article>) map.get("listArticle");
        int count=listArticle.size();
        for(int i=0;i<count;i++){
            int fid=listArticle.get(i).getFid();
            commentController.getCommentByFid(fid,map);
            List<Comment> listComment=(List<Comment>) map.get("listComment");
            String listCommentFid="listComment_"+fid;
            map.put(listCommentFid,listComment);
            map2.put("map",map);
        }
        List<Attention> attentions=attentionService.getAttentions();
        map.put("attention",attentions);
        List<Collect> collects=collectService.getCollects();
        map.put("collect",collects);
        List<Plate> plate=plateService.getAllPlate();
        map.put("plate", plate);
        return "list";
    }
      @RequestMapping("/getArticleBname")
      public String getArticleByBname(HttpServletRequest request, Map<Object,Object> map){
          String bname=request.getParameter("bname");
          articleController.getArticleBname(map,bname);
          List<Article> articles=(List<Article>) map.get("listArticle");
          map.put("listArticle",articles);
          return "list";
    }
    @RequestMapping("/getArticleTitle")
    public String getArticleTitle(Map<Object,Object> map,HttpServletRequest request){
        Article article=new Article();
        article.setTitles(request.getParameter("articleTitle"));
        articleController.getArticleTitle(article,map);
        List<Article> articles=(List<Article>) map.get("listArticle");
        map.put("listArticle",articles);
       // map.put("listArticle",articles);
        return "list";
    }
    //查询输出管理员首页信息，包括用户信息，帖子信息，板块信息
    @RequestMapping("/getAll_Admin")
    public String getAdminAllInfo(Map<Object,Object> map){
        //查询板块信息
        plateController.getAllPlate(map);
        //查询用户
        userController.getAllUser(map);
        //查询帖子
        articleController.getArticle(map);
        return "admin";
    }

}
