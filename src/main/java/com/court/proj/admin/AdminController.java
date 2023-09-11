package com.court.proj.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import retrofit2.http.GET;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/regist")
	public String adminReg() {
		
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
