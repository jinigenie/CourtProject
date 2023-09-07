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

		// csrf 토큰 x
		http.csrf().disable();

		// 사용자가 제공하는 폼 기반 로그인 기능을 사용할 수 있습니다.
		http.formLogin().loginPage("/user/login") // 로그인화면
				.loginProcessingUrl("/loginForm")// 로그인시도 할 때 요청 경로 -> 스프링이 로그인 시도를 가로채서 UserDetailService 객체로 연결
				.defaultSuccessUrl("/user/join") // 로그인 성공시 페이지
				.failureUrl("/login?err=true") // 로그인 실패시 이동할 url
				.and().exceptionHandling().accessDeniedPage("/deny") // 권한이 없을 때 이동할 리다이렉트 경로
				.and()
				// logout 주소를 직접 작성할 수 있고, 로그아웃 성공시 리다이렉트 할 경로도 logoutSuccessUrl("/hello") 로
				// 설정가능
				.logout().logoutUrl("/logout").logoutSuccessUrl("/hello"); // default로그아웃 경로 /logout 이다.
		return http.build();
	}
}
