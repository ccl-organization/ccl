package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/6/24
 * To change this template use File | Settings | File Templates.
 **/
public class JedisUtils {
    static RedisService redisService=new RedisService();

    public  static boolean set(String key,String value){
     return redisService.set(key,value);

    }

    public  static String get(String key){
        return  redisService.get(key);
    }


    public  static  Long zadd(String key,long score,String value){
        return  redisService.zadd(key,score,value);
    }


    public  static Set<String> zrange(String key, long start, long end){
        return  redisService.zrange(key,start,end);
    }


    public static  Set<String> zrevrange(String key, long start, long end){
        return  redisService.zrevrange(key,start,end);
    }





}
