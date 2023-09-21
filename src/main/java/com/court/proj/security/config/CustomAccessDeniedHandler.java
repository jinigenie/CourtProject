package com.court.proj.security.config;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private String redirectURL;

	public CustomAccessDeniedHandler(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("???????");
		if (request.getUserPrincipal() == null) {
			// 사용자가 인증되지 않은 경우
			String errorMessage = "로그인이 필요합니다. 인증되지 않은 사용자입니다.";
			String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
			response.sendRedirect("/login?error=" + encodedMessage);
		}
//		} else {
//			// 사용자가 인증은 되었지만 역할에 따른 접근 권한이 없는 경우
//			String errorMessage = "접근 권한이 없습니다.";
//			String encodedMessage = URLEncoder.encode(errorMessage, "UTF-8");
//			response.sendRedirect("/access-denied?error=" + encodedMessage);
//		}
		System.out.println("deny핸들");

		response.sendRedirect(redirectURL);

	}

}
