package com.wj.service;

import com.wj.mapper.ViaMapper;
import com.wj.pojo.Via;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaService {
    @Autowired
    ViaMapper viaMapper;
    public void setVia(Via via){
        viaMapper.insertVia(via);
    }
    //根据userid查询是否上传过头像
    public Via getVia(int userid){
        return  viaMapper.selectByUserid(userid);
    }
    //根据userid更新用户头像
    public void setPhoto(Via via){
        viaMapper.updatePhotoByUserid(via);
    }
    public void deleteVia(int userid){viaMapper.deleteByUserid(userid);}
}
