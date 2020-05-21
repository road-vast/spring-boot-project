package com.itcast.springboot.service;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class RedisService {
    private String id;
    private Integer userCount;

    public RedisService(String id, Integer userCount) {
        this.id = id;
        this.userCount = userCount;
    }

    //控制单元
    public void service(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String value = jedis.get("compid:" + id);
        try{
            //模拟业务在20s内被访问超过10次则会出错不能访问
            if (value == null){
                //超过最大值则会报异常
                jedis.setex("compid:" + id, 20, Long.MAX_VALUE - userCount + "");
            }else {
                Long count = jedis.incr("compid:" + id);
                business(id, userCount - (Long.MAX_VALUE - count));
            }
        }catch(JedisDataException e){
            System.out.println("使用已经达到次数上限，请升级会员级别");
        }finally {
            jedis.close();
        }
    }
    public void business(String id, Long count){
        System.out.println("用户： " + id + "业务操作执行" + count + "次");
    }
}
