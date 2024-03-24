package com.example.delifoodapi;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.delifoodapi.configuration.RsaKeyProperties;
@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class DelifoodapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelifoodapiApplication.class, args);
	}

}