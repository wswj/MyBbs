package com.wj.service;

import com.wj.mapper.CollectMapper;
import com.wj.pojo.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    CollectMapper collectMapper;
    public List<Collect> getCollect(int userid){

        return collectMapper.selectCollectByUserid(userid);
    }
    //添加收藏信息
    public void setCollect(Collect collect){

        collectMapper.insertCollect(collect);
    }
    //无条件查询收藏信息
    public List<Collect> getCollects(){

        return collectMapper.selectCollect();
    }
    //删除收藏信息
    public void deleteCollect(int sid){

        collectMapper.deleteCollectBySid(sid);
    }
    //删除关注信息通过userid和fid
    public void deleteCollectByUseridAndFid(Collect collect){

        collectMapper.deleteCollectByUseridAndFid(collect);
    }
    //删除该用户时删除收藏信息和被关注信息
    public void deleteCollectByUserid(int userid){

        collectMapper.deleteByUserid(userid);
    }
    //根据fid删除收藏信息
    public void deleteByFid(int fid){

        collectMapper.deleteByFid(fid);
    }
}
