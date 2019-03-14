package com.provider.demo;

import com.alibaba.fastjson.JSONObject;
import com.provider.demo.dao.JpaUsersDao;
import com.provider.demo.entity.Country;
import com.provider.demo.entity.JpaEntity;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.Jedis;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private JpaUsersDao jpaUsersDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void redis() {
        Jedis jedis = new Jedis();
        jedis.set("springCloud", "springCloud");
        logger.info("redis的value>>>" + jedis.get("springCloud"));
    }

    @Test
    public void getPermission() {
        logger.info(">>>Permission is " + userManager.getPermissionById(1).toString());
        //一对多表关联查询
        Country country = userManager.getCountryByCid(1);
        logger.info(">>>Country is " + country.toString());
    }

    @Test
    public void rabbitmq() {
        sender.sender("支付订单号：" + System.currentTimeMillis());
        apiCoreSender.user("用户管理!");
        apiCoreSender.userQuery("用户信息查询!");
        apiPaymentSender.order("订单管理!");
        apiPaymentSender.orderQuery("订单信息查询!");
        apiPaymentSender.orderDetailQuery("查询订单详细信息!");
    }

    @Test
    public void JpaTest() {
//		JpaEntity entity=new JpaEntity();
////		entity.setId(6);
//		entity.setUsername("jpa");
//		entity.setPassword("11111");
//		jpaUsersDao.save(entity);
//		List<JpaEntity> entities=jpaUsersDao.findByUsername("dankin");
//		logger.info(entities.toString());
//        JpaEntity entity = jpaUsersDao.annotation("dankin");
//        logger.info(">>> " + entity.toString());
        //测试jpa-Specification的复杂动态查询
        final Map<String,Object> conditions=new HashMap<>();
        conditions.put("username","dankin");
        conditions.put("password","e10adc3949ba59abbe56e057f20f883e");
        List<JpaEntity> list=jpaUsersDao.findAll(new Specification<JpaEntity>() {
            @Override
            public Predicate toPredicate(Root<JpaEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Field[] fields=JpaEntity.class.getDeclaredFields();
                List<Predicate> predicates=new ArrayList<>();
                for (int i=0;i<fields.length;i++){
                    fields[i].setAccessible(true);
                    String name=fields[i].getName();
                    if(conditions.containsKey(name)){
                        if(ObjectUtils.isEmpty(conditions.get(name))){
                            continue;
                        }
                        predicates.add(criteriaBuilder.like(root.<String>get(name),"%"+conditions.get(name)+"%"));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        logger.info("Specification查询结果>>>"+list);
    }

    @Test
    public void testJson() {
        String type = "ktw:123";
        String disLevel = "countymc";

        String param =
                "{'typename':'" + type + "','destcrs':'EPSG:4490','statisticsFields':'[{'field':'" + disLevel + "','operate':'Count'}]'," +
                        "'wkt':'','clip':'0','groupFields':'" + disLevel + "','type':'string'}";
        JSONObject object = (JSONObject) JSONObject.parse(param);
        System.out.println(object);
    }
}

