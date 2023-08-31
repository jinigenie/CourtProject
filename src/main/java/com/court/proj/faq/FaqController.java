package com.court.proj.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq")
public class FaqController {

	
	// FAQ 리스트
	@GetMapping("/list")
	public String list() {
		
		return "/faq/faqList";
	}
	
	// FAQ 작성/수정
	@GetMapping("/regist")
	public String detail() {
		
		return "/faq/faqRegist";
	}
	

	
	
}
