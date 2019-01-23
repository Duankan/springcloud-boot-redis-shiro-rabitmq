package com.provider.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.provider.demo.dao") //扫描的mapper
@EnableDiscoveryClient
@SpringBootApplication
public class ScdProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScdProviderApplication.class, args);
	}

}

