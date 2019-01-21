package com.provider.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ProviderController {
    @RequestMapping("/index")
    public String index() {
        return "《疯狂的石头》";
    }

    @RequestMapping("/rest")
    public Map<String, Object> restJson(@RequestBody String param) {
        Map<String, Object> result = new HashMap<>();
        List ls=new ArrayList();
        if (StringUtils.isEmpty(param)) {
            result.put("code", -1);
            result.put("msg", "参数为空!");
        } else {
            JSONObject object = (JSONObject) JSONObject.parse(param);
            result.put("code", 1);
            result.put("msg", "成功");
            ls.add(object);
            result.put("body", ls);
        }
        return result;
    }
}
