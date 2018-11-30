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
}
