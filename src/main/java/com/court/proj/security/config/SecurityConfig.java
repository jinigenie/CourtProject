package com.court.proj.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration // 설정파일이라고 선언
@EnableWebSecurity // 이 설정파일을 시큐리티 필터에 추가한다는 의미
@EnableGlobalMethodSecurity(prePostEnabled = true) // 어노테이션으로 권한을 지정할 수 있게 함
public class SecurityConfig {

	
	
	// 비밀번호를 암호화 하는 객체
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.csrf().disable();
		
		http //.antMatcher("/user/loginForm").addFilterBefore(new CustomLoginFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests( (authorize) -> authorize
				.antMatchers("/user/login").permitAll() // 로그인 페이지는 모든 사용자에게 허용
                .antMatchers("/user/loginForm").permitAll()
                .antMatchers("/main/**").permitAll()
                .antMatchers("/app/**").authenticated()
                //.antMatchers("/mypage/**").authenticated()
                .antMatchers("/mypage/**").hasRole("USER")
                .antMatchers("/fcltt/**").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/announce/announceModify").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/announce/announceRegist").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/announce/announceRegistForm").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/aplcn/**").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/faq/regist").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/faq/faqList").permitAll()
                .antMatchers("/notice/noticeModify").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/notice/noticeRegist").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/admin/regist").hasAnyRole("SUPERADMIN","JURIS","COURT")
                .antMatchers("/admin/list").hasAnyRole("SUPERADMIN","JURIS","COURT")
                )
				.exceptionHandling()
		        //.accessDeniedPage("/user/error")
				.accessDeniedHandler(customAccessDeniedHandler());
				

		
		http
		.formLogin()
		.loginPage("/user/login")
		.usernameParameter("username")
		.passwordParameter("user_pw")
		.loginProcessingUrl("/user/loginForm")
		.failureHandler(customLoginFailureHandler())
		.defaultSuccessUrl("/main/main");

		/*
		 * 인증이 필요한 경로
		 * app/**
		 * mypage/**
		 * 
		 * 
		 */
		
		
		/*
		 * 권한이 필요한 경로
		 * fcltt/**
		 * admin/adminList
		 * admin/adminRegist
		 * announce/announceModify
		 * announce/announceRegist
		 * announce/announceRegistForm
		 * aplcn/**
		 * faq/regist
		 * notice/noticeModify
		 * notice/noticeRegist
		 * 
		 */
		

		
		
		return http.build();
	}
	

	@Bean
	CustomAccessDeniedHandler customAccessDeniedHandler() {
		CustomAccessDeniedHandler myhandler = new CustomAccessDeniedHandler("/user/error");
		
		return myhandler;
	}
	
	@Bean
	CustomLoginFailureHandler customLoginFailureHandler() {
		CustomLoginFailureHandler myhandler = new CustomLoginFailureHandler();
		return myhandler;
	}
	
}
