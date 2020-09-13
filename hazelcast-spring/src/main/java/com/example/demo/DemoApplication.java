package com.example.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.web.WebFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Config config() {
		return new Config();
	}
	
	@Bean
	public WebFilter webFilter(HazelcastInstance hazelcastInstance){
	  Properties properties = new Properties();
	  properties.put("instance-name", hazelcastInstance.getName());
	  properties.put("sticky-session", "false");

	  return new WebFilter(properties);
	}	
}
