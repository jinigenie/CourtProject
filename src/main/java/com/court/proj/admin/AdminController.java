package com.court.proj.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
