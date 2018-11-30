package com.wj.utils;

public class PathUtil {
    private static String commonPath;
    private static String serverPath;
    public static String getCommonPath(){
        serverPath=System.getProperty("catalina.home");
        commonPath=serverPath+PropertyUtil.getPropertiesPath().getProperty("webapp");
        System.out.println("commonPath路径为"+commonPath);
        return commonPath;
    }
    public static String getArticlePath(){
        return PropertyUtil.getPropertiesPath().getProperty("articlePath");
    }
    public static String getUserPath(){
        return PropertyUtil.getPropertiesPath().getProperty("userPath");
    }
}
