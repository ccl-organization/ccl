package com.Uitils;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/
public class ParamsCheckUtils {



    public static boolean checkParams(Object ... objects){
        try {
            for (Object o:objects){
                if (o==null || o.equals("") ){
                    return false;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
