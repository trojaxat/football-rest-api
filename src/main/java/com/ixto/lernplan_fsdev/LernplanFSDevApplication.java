package com.ixto.lernplan_fsdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.ixto.lernplan_fsdev")
@EnableSwagger2
public class LernplanFSDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(LernplanFSDevApplication.class, args);
	}

}

