package com.yambay.userdevice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Slf4j
@EnableAspectJAutoProxy
public class UserDeviceServiceApplication {

	public static void main(String[] args)
	{
		log.info("*** User Device Service Startup ***");
		SpringApplication.run(UserDeviceServiceApplication.class, args);
	}
}
