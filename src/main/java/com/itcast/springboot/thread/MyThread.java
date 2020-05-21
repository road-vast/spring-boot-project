package com.itcast.springboot.thread;


import com.itcast.springboot.service.RedisService;

import javax.annotation.Resource;

public class MyThread extends Thread{
    private String id;
    private Integer userCount;
    RedisService redisService;

    public MyThread(String id, Integer userCount) {
        this.id = id;
        this.userCount = userCount;
    }

    public void run(){
        redisService = new RedisService(id, userCount);
        while(true){
            redisService.service();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

