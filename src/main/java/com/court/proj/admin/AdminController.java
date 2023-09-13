package com.court.proj.admin;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.extras.springsecurity5.auth.Authorization;

import retrofit2.http.GET;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/regist")
	public String adminReg(Authentication auth) {
		
		
		System.out.println(auth);
		
		//System.out.println( ((AdminVO)auth.getPrincipal()).toString() );
		
		
		
		return "admin/adminRegist";
	}
	
	@GetMapping("/list")
	public String adminList() {
		
		return "admin/adminList";
	}
	
	@GetMapping("/login")
	public String login() {
		return "admin/adminLogin";
	}
	
//	@PostMapping("/loginForm")
//	public String loginForm() {
//		return "";
//	}
	
}
