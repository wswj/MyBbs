package com.wj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static Properties getPropertiesPath(){
        Properties prop=new Properties();
       try{

           InputStream inputStream=PropertyUtil.class.getClassLoader().getResourceAsStream("pathconfig.properties");
           prop.load(inputStream);
       }catch (IOException e){
           e.printStackTrace();
       }
       return prop;
    }
}
