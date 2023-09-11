package com.court.proj.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
		
//		http.formLogin().loginPage("/user/login")
//		.usernameParameter("username")
//		.passwordParameter("user_pw")
//		.loginProcessingUrl("/user/loginForm")
//		.defaultSuccessUrl("/main/");
//		
//		/*
//		 * 인증이 필요한 경로
//		 * 
//		 */
//		
//		
//		/*
//		 * 권한이 필요한 경로
//		 */
//		
//		http.authorizeRequests( (authorize) -> authorize
//				.antMatchers("/user/login").permitAll() // 로그인 페이지는 모든 사용자에게 허용
//                .antMatchers("/user/loginForm").permitAll()
//                .antMatchers("/fcltt/**").authenticated()
//                .antMatchers("/admin/regist").hasAnyRole("SUPERADMIN,JURIS,COURT"))
//				.exceptionHandling()
//		        .accessDeniedPage("/user/error")
//				; 
		
		
		return http.build();
	}
}
