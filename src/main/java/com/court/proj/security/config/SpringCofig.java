package com.court.proj.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Configuration
public class SpringCofig {

	@Value("${phone_api_key}")
	private String phone_api_key;
	@Value("${phone_api_secretkey}")
	private String phone_api_secretkey;
	
	@Bean
	DefaultMessageService messageService() {

			return	NurigoApp.INSTANCE.initialize(phone_api_key, phone_api_secretkey,
						"https://api.coolsms.co.kr");
				
	}
	

	
}
