package com.court.proj.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	// 메인화면
	@GetMapping("/main")
	public String main() {
		
		return "/main/mainPage";
	}
	

	
}
