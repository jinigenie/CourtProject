package com.court.proj.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	MypageService mypageService;

	@GetMapping("/main")
	public String mypage(Model model) {
		
		int user_proper_num = 1;
		UserVO userVO = mypageService.getUser(user_proper_num);
		model.addAttribute("userVO", userVO);
		System.out.println(userVO.toString());
		
		return "mypage/main";
	}

	@GetMapping("/modify")
	public String modify(Model model) {
		
		int user_proper_num = 1;
		UserVO userVO = mypageService.getUser(user_proper_num);
		model.addAttribute("userVO", userVO);
		System.out.println(userVO.toString());
		
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
	
	@PostMapping("/deleteform")
	public String del(UserVO vo) {
		
		int result = mypageService.deleteUpdate(vo);
		System.out.println(result);
		return "redirect:../main/";
	}
}
