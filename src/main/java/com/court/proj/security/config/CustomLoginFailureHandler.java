package com.court.proj.security.config;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler{

	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		
		
		
        if(exception instanceof UsernameNotFoundException) {
        	String errorMessage = "존재하지 않는 회원입니다.";
        	String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
            response.sendRedirect("/user/login?error="+encodedMessage);
        }else if (exception instanceof BadCredentialsException) {
            // 비밀번호가 틀렸을 경우 처리
        	String errorMessage = "아이디 혹은 비밀번호를 확인해주세요";
        	String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
            response.sendRedirect("/user/login?error="+encodedMessage);
        } else if (exception instanceof DisabledException) {
            // isEnabled()가 false일 경우 처리
        	// 실패 메시지 설정
            String errorMessage = "탈퇴한 회원입니다";
            // 메시지를 쿼리 문자열로 인코딩하여 리다이렉트
            String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
            response.sendRedirect("/user/login?error=" + encodedMessage);
        } else {
            // 기타 인증 실패 처리
            response.sendRedirect("/user/login?error=other");
        }
		
	}

}
