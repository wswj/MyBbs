package com.wj.controller;

import com.wj.pojo.Plate;
import com.wj.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/plateController")
@SessionAttributes(value = {"plate"})
public class PlateController{
    @Autowired
    PlateService plateService;
    @RequestMapping("/getPlate")
    public void getAllPlate(Map<Object,Object> map, HttpSession session) {
         List<Plate> plate=plateService.getAllPlate();

         map.put("plate",plate);
        //session.setAttribute("plate",plate);

    }
}
