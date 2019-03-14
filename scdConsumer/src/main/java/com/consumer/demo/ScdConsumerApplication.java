package com.consumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@SpringBootApplication
public class ScdConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScdConsumerApplication.class, args);
	}

	/**
	 * @return
	 * @author dankin
	 * @date 19年年前
	 * @descr springcolud的rest模板，启用负载均衡，默认算法是轮询
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}

