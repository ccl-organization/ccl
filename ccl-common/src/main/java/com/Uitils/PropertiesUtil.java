package com.Uitils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * Date: 2018/4/19
 * To change this template use File | Settings | File Templates.
 **/
public class PropertiesUtil {

    private static final Properties pro;

    static {
        pro = new Properties();
        try {
            pro.load(PropertiesUtil.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return pro.getProperty(key);
    }

    public static String get(String key, String defaultVal) {
        return pro.getProperty(key, defaultVal);
    }

    public static List<String> getList(String key){
        return  Arrays.asList(pro.getProperty(key).split(","));
    }


    public static void main(String[] args) {
        System.out.println("ip= "+PropertiesUtil.get("spring.profiles.active"));
    }

}
