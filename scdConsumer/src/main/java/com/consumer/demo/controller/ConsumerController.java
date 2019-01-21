package com.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/consumer")
    public String index(){
        String result=restTemplate.getForObject("http://ticket-provider/index", String.class);
        return result;
    }
    @RequestMapping("/restConsumer")
    public Map<String,Object> rest(@RequestBody String param){
        Map<String,Object> result=new HashMap<>();
        result=restTemplate.postForObject("http://ticket-provider/rest",param,Map.class);
        return result;
    }
}
