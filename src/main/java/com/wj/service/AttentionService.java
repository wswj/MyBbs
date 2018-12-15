package com.wj.service;

import com.wj.mapper.AttentionMapper;
import com.wj.pojo.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionService {
    @Autowired
    AttentionMapper attentionMapper;
    public List<Attention> getAttention(int userid){

        return attentionMapper.selectAttentionByUserid(userid);
    }
    public List<Attention> getAttentionBe(int beuserid){

        return attentionMapper.selectByBeUserid(beuserid);
    }
    //添加关注信息
    public void setAttention(Attention attention){

        attentionMapper.insertAttention(attention);
    }
    //无条件查询所有关注信息
    public List<Attention> getAttentions(){

        return attentionMapper.selectAttention();
    }
    //根据gid删除关注信息
    public void deleteAttention(int gid){

        attentionMapper.deleteAttention(gid);
    }
    //在个人界面删除关注信息
    public void deleteAttentionAtMyself(Attention attention){

        attentionMapper.deleteByUseridAndBeuserid(attention);
    }
    //删除用户时删除关注信息
    public void deleteAttentionByUserid(int userid){

        attentionMapper.deleteByUserid(userid);
    }
}
