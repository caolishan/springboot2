package com.example.springboot2;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.springboot2.dao"},sqlSessionTemplateRef = "sqlSessionTemplate")
public class Springboot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}
}
