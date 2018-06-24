package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/
public class RedisService {
    private static Jedis jedis;
    public static void main(String[] args) {

        JedisShardInfo info = new JedisShardInfo("apria.cn", 9000, 20000);
        info.setPassword("123qwe");
        Jedis jedis=info.createResource();

        String s= jedis.set("name", "java知识分享网"); // 设置值
        String value=jedis.get("name"); // 获取值
        System.out.println(value);




    }


//
//    private static void   init()   {
//        JedisShardInfo info = new JedisShardInfo("apria.cn", 9000, 20000);
//        info.setPassword("123qwe");
//         jedis=info.createResource();
//    }

   static   {
        JedisShardInfo info = new JedisShardInfo("apria.cn", 9000, 20000);
        info.setPassword("123qwe");
        jedis=info.createResource();
    }

    public  boolean set(String key,String value){
        try {
          //  init();
            if (jedis.set(key,value).toLowerCase().equals("ok"))
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    public  String get(String key){
       // init();
        return  jedis.get(key);
    }


    public  Long zadd(String key,long score,String value){

       // init();
        return  jedis.zadd(key,score,value);
    }


    public Set<String> zrange(String key, long start, long end){
      //  init();
        return  jedis.zrange(key,start,end);
    }


    public  Set<String> zrevrange(String key, long start, long end){
       // init();
        return  jedis.zrevrange(key,start,end);
    }



}
