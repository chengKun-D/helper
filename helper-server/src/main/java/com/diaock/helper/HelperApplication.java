package com.diaock.helper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.diaock.helper.mapper")
public class HelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelperApplication.class, args);
	}

}
