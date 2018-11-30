package com.wj.mapper;

import com.wj.pojo.Plate;
import com.wj.pojo.PlateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlateMapper {
    //查询所有的板块
    List<Plate> selectAll();
    long countByExample(PlateExample example);

    int deleteByExample(PlateExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Plate record);

    int insertSelective(Plate record);

    List<Plate> selectByExample(PlateExample example);

    Plate selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Plate record, @Param("example") PlateExample example);

    int updateByExample(@Param("record") Plate record, @Param("example") PlateExample example);

    int updateByPrimaryKeySelective(Plate record);

    int updateByPrimaryKey(Plate record);
}