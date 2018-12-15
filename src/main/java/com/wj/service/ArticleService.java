package com.wj.service;

import com.wj.mapper.ArticleMapper;
import com.wj.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public void updateArticleUsername(Article article){

        articleMapper.updateArticleSetup(article);
    }
    public List<Article> getArticleByUserId(int userid){

        return articleMapper.selectByArticleId(userid);
    }
    public Article getArticleKey(int fid){

        return articleMapper.selectByPrimaryKey(fid);
    }
    public void setArticle(Article article){

        articleMapper.insertArticle(article);
    }
    public void deleteArticle(Integer fid){

        articleMapper.deleteByFid(fid);
    }
    //根据bname板块名字获得帖子
    public List<Article> getArticleByBname(String bname){

        return articleMapper.selectArticleByBnmae(bname);
    }
    //无条件查询帖子
    public List<Article> getArticle(){

        return articleMapper.selectArticle();
    }
    //根据搜索条件查询帖子
    public List<Article> getArticleBySearch(Article article){

        return articleMapper.selectArticleBySearch(article);
    }
    //查询帖子信息及发帖用户的信息
    public Article getArticleInfo(int fid){

        return articleMapper.selectArticleInfo(fid);
    }
    //删除用户时删除帖子
    public void deleteArticle(int userid){

        articleMapper.deleteByUserid(userid);
    }
    //修改帖子状态
    public void updateStatus(Article article){

        articleMapper.updateStatus(article);
    }
    //按板块名删除帖子
    public void deleteArticleByBname(String bname){

        articleMapper.deleteByBname(bname);
    }
    //按fid删除帖子
    public void deleteArticleByFid(int fid){
        articleMapper.deleteByFid(fid);
    }
    //修改板块名字
    public void setBname(Article article){

        articleMapper.updateBname(article);
    }
}
