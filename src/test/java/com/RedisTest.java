package com;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.sys.entity.Smwy;

@SpringBootTest
public class RedisTest {
	
	@Autowired
	private  RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void caonima2(){
    	Smwy smwy = new Smwy("张明亮","死了");
    	redisTemplate.opsForValue().set("123", smwy);
    	System.out.println(redisTemplate.opsForValue().get("123"));
	    	
    }
	@Test
	public void caonima1(){
//		Smwy smwy = new Smwy("张明亮","死了");
		redisTemplate.opsForValue().set("nmsl","hahhaha");
		System.out.println(redisTemplate.opsForValue().get("nmsl"));
		
	}
}
