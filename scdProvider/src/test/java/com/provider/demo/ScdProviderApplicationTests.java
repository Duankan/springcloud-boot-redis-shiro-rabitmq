package com.provider.demo;

import com.provider.demo.service.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@MapperScan("com.provider.demo.dao") //扫描的mapper
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScdProviderApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	UserManager userManager;
	@Test
	public void contextLoads() {
	}
	@Test
	public void redis(){
		Jedis jedis=new Jedis();
		jedis.set("springCloud","springCloud");
		logger.info(">>>redis的value:"+jedis.get("springCloud"));
	}
	@Test
	public void getPermission(){
		logger.info(">>>Permission is "+userManager.getPermissionById(1).toString());
	}
}

