package com.wj.mapper;

import com.wj.pojo.Via;
import com.wj.pojo.ViaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViaMapper {
   //添加头像
    Integer insertVia(Via via);
    //根据userid查询是否上传过头像
    Via selectByUserid(int userid);
    //根据userid更新用户头像
    Integer updatePhotoByUserid(Via via);
    //根据userid删除用户头像信息
    Integer deleteByUserid(int userid);
    long countByExample(ViaExample example);

    int deleteByExample(ViaExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Via record);

    int insertSelective(Via record);

    List<Via> selectByExample(ViaExample example);

    Via selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Via record, @Param("example") ViaExample example);

    int updateByExample(@Param("record") Via record, @Param("example") ViaExample example);

    int updateByPrimaryKeySelective(Via record);

    int updateByPrimaryKey(Via record);
}