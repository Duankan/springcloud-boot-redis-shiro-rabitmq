package com.provider.demo;

import com.provider.demo.entity.Country;
import com.provider.demo.rabbitmq.ApiCoreSender;
import com.provider.demo.rabbitmq.ApiPaymentSender;
import com.provider.demo.rabbitmq.PaymentNotifySender;
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
	@Autowired
	private PaymentNotifySender sender;
	@Autowired
	private ApiCoreSender apiCoreSender;
	@Autowired
	private ApiPaymentSender apiPaymentSender;
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
		//一对多表关联查询
		Country country=userManager.getCountryByCid(1);
		logger.info(">>>Country is "+country.toString());
	}
	@Test
	public void rabbitmq(){
		sender.sender("支付订单号："+System.currentTimeMillis());
		apiCoreSender.user("用户管理!");
		apiCoreSender.userQuery("用户信息查询!");
		apiPaymentSender.order("订单管理!");
		apiPaymentSender.orderQuery("订单信息查询!");
		apiPaymentSender.orderDetailQuery("查询订单详细信息!");
	}
}

