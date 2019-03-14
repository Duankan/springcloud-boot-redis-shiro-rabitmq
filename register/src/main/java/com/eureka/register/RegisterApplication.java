package com.eureka.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dankin
 * @date 2019-03-04
 * @descr 开发于年前，这是springcloud的注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
}

