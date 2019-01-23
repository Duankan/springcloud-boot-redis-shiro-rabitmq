package com.consumer.demo.controller;

import com.provider.demo.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value="Country/{cid}",method = RequestMethod.GET)
    public Country getCountry(@PathVariable Integer cid){
        Country country=restTemplate.getForObject("http://ticket-provider/Country/"+cid,Country.class);
        return country;
    }
    @RequestMapping("/other")
    public Map<String,Object> othertProject(@RequestBody String param){
        Map<String,Object> result=new HashMap();
        result= (Map<String, Object>) restTemplate.postForEntity("http://192.168.1.86:8080/login",param,Map.class);
        return result;
    }
}
