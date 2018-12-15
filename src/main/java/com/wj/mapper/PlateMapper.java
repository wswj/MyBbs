package com.wj.mapper;

import com.wj.pojo.Plate;
import com.wj.pojo.PlateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlateMapper {
    //查询所有的板块
    List<Plate> selectAll();
    //查询板块名是否存在
    Plate selectBnameExit(String bname);
    //新建板块
    Integer insertPlate(Plate plate);
    //删除板块
    Integer deletePlateByBid(int bid);
    //按bid查询板块
    Plate selectByBid(int bid);
    //修改板块
    Integer updatePlate(Plate plate);
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