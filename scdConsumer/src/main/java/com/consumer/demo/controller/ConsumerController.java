package com.consumer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
