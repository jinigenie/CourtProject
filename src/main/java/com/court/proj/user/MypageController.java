package com.court.proj.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userMypage")
public class MypageController {

	@GetMapping("/")
	public String mypage() {
		return "userMypage/mypage";
	}

	@GetMapping("/modify")
	public String modify() {
		return "userMypage/modify";
	}
	
	@GetMapping("/history")
	public String history() {
		return "userMypage/history";
	}
	
	@GetMapping("/pause")
	public String pause() {
		return "userMypage/pause";
	}
	
	@GetMapping("/status")
	public String status() {
		return "userMypage/status";
	}
}
