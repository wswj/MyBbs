package com.wj.service;

import com.wj.mapper.PlateMapper;
import com.wj.pojo.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateService {
    @Autowired
    PlateMapper plateMapper;
    //查询板块信息
    public List<Plate> getAllPlate(){

        return plateMapper.selectAll();
    }
    //查询板块名是否存在
    public Plate getPlate(String bname){

        return plateMapper.selectBnameExit(bname);
    }
    //新建板块
    public void setPlate(Plate plate){

        plateMapper.insertPlate(plate);
    }
    //删除板块
    public void deletePlate(int bid){

        plateMapper.deletePlateByBid(bid);
    }
    //按bid查询板块
    public Plate getPlateByBid(int bid){

        return plateMapper.selectByBid(bid);
    }
    //修改板块
    public void updatePlate(Plate plate){

        plateMapper.updatePlate(plate);
    }
}
