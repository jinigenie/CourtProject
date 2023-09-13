package com.court.proj.security.config;

import java.io.IOException;

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
		
		System.out.println("deny핸들");
		
		response.sendRedirect(redirectURL);
		
		
	}

}
