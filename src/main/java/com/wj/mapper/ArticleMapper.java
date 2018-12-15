package com.wj.mapper;

import com.wj.pojo.Article;
import com.wj.pojo.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //修改article表中的user信息
    Integer updateArticleSetup(Article article);
    //按userid查询用户的帖子
    List<Article> selectByArticleId(int userid);
    //添加帖子
    Integer insertArticle(Article article);
    //根据fid删除帖子
    Integer deleteByFid(int fid);
    //根据bname板块名字获得贴子
    List<Article> selectArticleByBnmae(String bname);
    //无条件查询帖子
    List<Article> selectArticle();
    //根据搜索条件查询帖子
    List<Article> selectArticleBySearch(Article article);
    //查询帖子信息以及发帖用户的信息
    Article selectArticleInfo(int fid);
    //根据userid删除帖子
    Integer deleteByUserid(int userid);
    //修改帖子状态
    Integer updateStatus(Article article);
    //按板块名删除文章
    Integer deleteByBname(String bname);
    //修改帖子所属板块名
    Integer updateBname(Article article);
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}