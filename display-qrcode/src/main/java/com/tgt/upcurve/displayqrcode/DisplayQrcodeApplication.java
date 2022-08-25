package com.tgt.upcurve.displayqrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class DisplayQrcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayQrcodeApplication.class, args);
	}

}
