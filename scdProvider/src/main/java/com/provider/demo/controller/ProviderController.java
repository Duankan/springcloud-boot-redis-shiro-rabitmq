package com.provider.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProviderController {
    @RequestMapping("/index")
    public String index(){
        return "《疯狂的石头》";
    }
}
