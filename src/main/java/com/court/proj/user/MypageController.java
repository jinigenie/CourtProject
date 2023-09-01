package com.court.proj.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

	@GetMapping("/main")
	public String mypage() {
		return "mypage/main";
	}

	@GetMapping("/modify")
	public String modify() {
		return "mypage/modify";
	}
	
	@GetMapping("/history")
	public String history() {
		return "mypage/history";
	}
	
	@GetMapping("/pause")
	public String pause() {
		return "mypage/pause";
	}
	
	@GetMapping("/status")
	public String status() {
		return "mypage/status";
	}

	@GetMapping("/modal")
	public String modal() {
		return "mypage/modal";
	}
}
