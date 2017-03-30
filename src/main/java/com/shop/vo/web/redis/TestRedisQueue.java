package com.shop.vo.web.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

public class TestRedisQueue {

	public static byte[] redisKey = "key".getBytes();
    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init() throws IOException {
    	
        for (int i = 0; i < 1000000; i++) {
            //Message message = new Message(i, "这是第" + i + "个内容");
        	
        	Message message = new Message();
        	message.setId(i);
        	message.setContent("这是第" + i + "个内容");
        	
            JedisUtil.lpush(redisKey, ObjectUtil.object2Bytes(message));        	
        }
        
        System.out.println(JedisUtil.get("age"));

    }

    public static void main(String[] args) {
        try {
            pop();
            //System.out.println(JedisUtil.get("age"));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pop() throws Exception {
        byte[] bytes = JedisUtil.rpop(redisKey);
        Message msg = (Message) ObjectUtil.bytes2Object(bytes);
        if (msg != null) {
            System.out.println(msg.getId() + "----" + msg.getContent());
        }
    }
    
}
