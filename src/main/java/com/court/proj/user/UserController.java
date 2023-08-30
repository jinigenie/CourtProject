package com.court.proj.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//나중에 없앨 메소드임.
	@GetMapping("/main")
	public String main() {
		return "index";
	}
	
	@GetMapping("/join")
	public String join() {
		return "user/userjoin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}
