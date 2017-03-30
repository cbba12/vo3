package com.shop.vo.web.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		Jedis redis = new Jedis("localhost");
		// SimpleExample(redis);

		// ListExample(redis,20000);

		//PublishExample(redis, 20000);
		
		//SimpleExample(redis);
		
		//ListExample(redis, 10);
		
		
		
		mapExample(redis);
	}

	// 简单添加信息
	public static void SimpleExample(Jedis redis) {
		redis.set("key1", "I am value 1");
		String ss = redis.get("key1");
		System.out.println(ss);
	}

	// 队列添加信息
	public static void ListExample(Jedis redis, int number) {
		String messageStr = "";
		int count = 0;
		while (count++ < number) {
			messageStr = "this is " + count + " message!";
			redis.rpush("logstash-test-list", messageStr);			
			System.out.println(messageStr);
		}
	}

	// map添加信息
	public static void mapExample(Jedis redis) {

		redis.hdel("user3");
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("name", "xinxin");
		maps.put("age", "22");
		maps.put("qq", "123456");

		redis.hmset("user3", maps);

	}

	// 发布订阅
	public static void PublishExample(Jedis redis, int number) {
		String messageStr = "";
		int count = 0;
		while (count++ < number) {
			messageStr = "this is " + count + " message!";
			redis.publish("logstash-test-list", messageStr);
			System.out.println(messageStr);
		}
	}

}
