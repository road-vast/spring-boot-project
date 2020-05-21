package com.itcast.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootRedisApplicationTests {

    @Test
    void contextLoads() {
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //2.操作redis
//        jedis.set("name", "itheima");
        System.out.println(jedis.get("name"));
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void testList(){
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //2.操作redis
//        jedis.rpush("list1", "a", "b", "c");
        List<String> datas = jedis.lrange("list1", 0, -1);
        System.out.println("list1中的数据：");
        for (String data:
             datas) {
            System.out.println(data);
        }
        //3.关闭连接
        jedis.close();
    }
    @Test
    public void TestHash(){
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis
//        jedis.hset("hash1", "a", "a1");
//        jedis.hset("hash1", "b", "b1");
        Map<String, String> result = jedis.hgetAll("hash1");
        System.out.println(result);
        //3.关闭连接
        jedis.close();
    }

}
