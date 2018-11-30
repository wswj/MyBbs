package com.wj.mapper;

import com.wj.pojo.Attention;
import com.wj.pojo.AttentionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionMapper {
    //无条件查询所有关注信息
    List<Attention> selectAttention();
    //按userid查询用户关注了谁
    List<Attention> selectAttentionByUserid(int userid);
    //按beuserid查询关注用户的人
    List<Attention> selectByBeUserid(int beuserid);
    //添加关注信息
    Integer insertAttention(Attention attention);
    //根据gid删除关注信息
    Integer deleteAttention(int gid);
    //在个人界面删除关注信息
    Integer deleteByUseridAndBeuserid(Attention attention);
    long countByExample(AttentionExample example);

    int deleteByExample(AttentionExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionExample example);

    Attention selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionExample example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}