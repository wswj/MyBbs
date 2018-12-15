package com.wj.controller;

import com.wj.pojo.Article;
import com.wj.pojo.Article2;
import com.wj.service.ArticleService;
import com.wj.service.CommentService;
import com.wj.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/articleController")
@SessionAttributes(value = "article_Show")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/setArticle")
    public String setArticle(HttpSession session, Article2 article2,
                             HttpServletRequest request, @RequestParam("photo") MultipartFile file){
        System.out.println("提交的板块名为"+article2.getBname());
        String projectname;
        projectname=request.getSession().getServletContext().getRealPath("/");
        System.out.println("projectname1"+projectname);
        projectname=projectname.substring(0,projectname.length()-1);
        System.out.println("projectname2"+projectname);
        if(projectname.indexOf("/")==-1){
            projectname=projectname.substring(projectname.lastIndexOf("\\"),projectname.length());
            System.out.println("在非Linux系统下"+projectname);
        }else{
            projectname=projectname.substring(projectname.lastIndexOf("/"),projectname.length());
            System.out.println("在Linux系统下"+projectname);
        }
        String filePath= PathUtil.getCommonPath()+projectname+PathUtil.getArticlePath();
        System.out.println("图片文件路径"+filePath);
        String newFilename="photo";
        String username=(String) session.getAttribute("username");
        System.out.println(username!=null);
        if(username!=null){
            int userid=(int)session.getAttribute("userid");
            String fileName=file.getOriginalFilename();
            if(!fileName.equals("")){
                newFilename= UUID.randomUUID()+fileName;
                File targetFile=new File(filePath,newFilename);
                System.out.println(targetFile);
                try{file.transferTo(targetFile);}catch (IOException e){
                    e.printStackTrace();
                }
            }
            Article article=new Article(article2,newFilename);
            article.setPhoto(newFilename);
            article.setUserid(userid);
            article.setUsername((String) session.getAttribute("username"));
            article.setStatus(0);
            article.setTime(new Date());
            articleService.setArticle(article);
        }

        //article.setUserid((Integer) session.getAttribute("userid"));


        return "redirect:/index.jsp";
    }
    public void getArticle(Map<Object,Object> map){
        List<Article> listArticle=articleService.getArticle();
        map.put("listArticle",listArticle);
    }
    @RequestMapping("/deleteArticle")
    public String deleteArticle(Article article){
        articleService.deleteArticle(article.getFid());
        commentService.deleteCommentByFid(article.getFid());
        return "redirect:/userController/getMyself.do";
    }
    public void getArticleBname(Map<Object,Object> map,String bname){
        List<Article> listArticle=articleService.getArticleByBname(bname);
        map.put("listArticle",listArticle);
    }
    public void getArticleTitle(Article article,Map<Object, Object> map) {
//        Article article=new Article();
//        article.setTitles(request.getParameter("articleTitle"));
        List<Article> listArticle = articleService.getArticleBySearch(article);
        map.put("listArticle", listArticle);
    }
    @RequestMapping("/getArticleFid")
    public String getArticleFid(@RequestParam("fid") int fid,Map<Object,Object> map){
        Article article=articleService.getArticleInfo(fid);
        System.out.println("帖子名为"+article.getTitles());
        map.put("article_Show",article);
        return "redirect:/content/articleShow.jsp";
    }
    //修改帖子状态
    @RequestMapping("/articleStatus")
    public String updateStatus(Article article){
        articleService.updateStatus(article);
        return "redirect:/admin/index.jsp";
    }


}
