package com.wj.mapper;

import com.wj.pojo.Collect;

import java.util.List;

//import com.wj.pojo.CollectExample;


public interface CollectMapper {
   // long countByExample(CollectExample example);

   // int deleteByExample(CollectExample example);
    List<Collect> selectCollectByUserid(int userid);
    //添加收藏信息
    Integer insertCollect(Collect collect);
    //无条件查询收藏信息
    List<Collect> selectCollect();
    //删除收藏信息
    Integer deleteCollectBySid(int sid);
    //删除关注信息通过userid和fid
    Integer deleteCollectByUseridAndFid(Collect collect);
    int deleteByPrimaryKey(Integer sid);

    int insert(Collect record);

    int insertSelective(Collect record);

   // List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer sid);

    //int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

   // int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}