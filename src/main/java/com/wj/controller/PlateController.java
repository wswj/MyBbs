package com.wj.controller;

import com.wj.pojo.Article;
import com.wj.pojo.Plate;
import com.wj.service.ArticleService;
import com.wj.service.CollectService;
import com.wj.service.CommentService;
import com.wj.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plateController")
@SessionAttributes(value = {"plate","plateEdit"})
public class PlateController{
    @Autowired
    PlateService plateService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CollectService collectService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/getPlate")
    public void getAllPlate(Map<Object,Object> map) {
         List<Plate> plate=plateService.getAllPlate();

         map.put("plate",plate);
        //session.setAttribute("plate",plate);
    }
    @RequestMapping("/deletePlate")
    public String deletePlate(@RequestParam("bid") int bid){
        //按bid得到板块名
        Plate plate=plateService.getPlateByBid(bid);
        String plateName=plate.getBname();
        //按板块名字获得该模块下的帖子
        List<Article> listArticle=articleService.getArticleByBname(plateName);
        //删除帖子下的评论及帖子收藏信息
        for (Article article: listArticle){
            int articleFid=article.getFid();
            //删除帖子下的评论
            commentService.deleteCommentByFid(articleFid);
            //删除该帖子的收藏信息
            collectService.deleteByFid(articleFid);
            //删除帖子
            articleService.deleteArticleByFid(articleFid);
        }
        //删除板块
        plateService.deletePlate(bid);
        //按bname删除帖子
        return "redirect:/admin/index.jsp";
    }
    @RequestMapping("/setPlate")
    @ResponseBody
    public String setPlate(Plate plate, HttpServletRequest request){
        String bname=request.getParameter("bname");
        Plate plate1=plateService.getPlate(bname);
        plate.setBname(bname);
        System.out.println("新建板块名为"+bname);
        //System.out.println("值为"+plate1.getBname()!=null);
        if(plate1!=null){
            return "NO";
        }else {
            plate.setBtime(new Date());
            plateService.setPlate(plate);
            return "OK";
        }

        //return "redirect:/admin/index.jsp";
    }
    //修改板块信息提交
    @RequestMapping("/getUpdatePlate")
    public String updatePlate(Plate plate,Map<Object,Object> map){
        System.out.println("板块名"+plate.getBname());
        map.put("plateEdit",plate);
        return "redirect:/admin/plateEdit.jsp";
    }
    //提交修改信息
    @RequestMapping("/updatePlate")
    @ResponseBody
    public String updatePlate(HttpSession session,HttpServletRequest request){
        Plate plate1=(Plate) session.getAttribute("plateEdit");
        String oldName=plate1.getBname();

        if(!oldName.equals(request.getParameter("bname"))){
            List<Article> list=articleService.getArticleByBname(oldName);
            for (Article article1:list) {
                article1.setBname(request.getParameter("bname"));
                articleService.setBname(article1);
            }
            Plate plate=new Plate();
            int bid=Integer.parseInt(request.getParameter("bid"));
            System.out.println("板块id为"+bid);
            System.out.println();
            String bname=request.getParameter("bname");
            plate.setBname(bname);
            plate.setBid(bid);
            plateService.updatePlate(plate);
            //plateService.updatePlate(plate);

            return "OK";
        }else {
            return "NO";
        }

    }
}
