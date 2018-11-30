package com.wj.controller;

import com.wj.pojo.Via;
import com.wj.service.ViaService;
import com.wj.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
@RequestMapping("/viaController")
public class ViaController {
    @Autowired
    ViaService viaService;
    @RequestMapping("/setUserPhoto")
    public String setUserPhoto(@RequestParam("photo") MultipartFile file, HttpSession session, HttpServletRequest request){
        String projectname;
        projectname=request.getSession().getServletContext().getRealPath("/");
        projectname=projectname.substring(0,projectname.length()-1);
        if(projectname.indexOf("/")==-1){
            //在非Linux系统下
            projectname=projectname.substring(projectname.lastIndexOf("\\"),projectname.length());

        }else {
            //在Linux系统下
            projectname=projectname.substring(projectname.lastIndexOf("/"),projectname.length());
        }
        //图片文件路径
        String filePath= PathUtil.getCommonPath()+projectname+PathUtil.getUserPath();
        //新文件的名字
        String newFileName=null;
        int userid=(int)session.getAttribute("userid");
        Via via=new Via();
        via.setUserid(userid);
        String fileName=file.getOriginalFilename();
//        Via via1=viaService.getVia(userid);
//        Integer vuserid=via1.getUserid();
       // System.out.println("值为"+viaService.getVia(userid).getUserid());
        if(viaService.getVia(userid)==null){
            if(!fileName.equals("")){
                newFileName= UUID.randomUUID()+fileName;
                File targetFile=new File(filePath,newFileName);
                try{file.transferTo(targetFile);}catch(IOException e){
                    e.printStackTrace();
                }
                via.setPhoto(newFileName);
                viaService.setVia(via);
        }
        }else{
            if(!fileName.equals("")){
                String filenamenew=viaService.getVia(userid).getPhoto();
                File targetFile=new File(filePath,filenamenew);
                //删除之前上传的头像图片
                targetFile.delete();
                newFileName=UUID.randomUUID()+fileName;
                targetFile=new File(filePath,newFileName);
                try {
                    file.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                via.setPhoto(newFileName);
                viaService.setPhoto(via);

            }
        }


        return "redirect:/userController/getMyself.do";
    }
}
