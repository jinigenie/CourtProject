package com.court.proj.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@GetMapping("/list")
	public String list() {
		
		return "/faq/faqList";
	}
	
	@GetMapping("/detail")
	public String detail() {
		
		return "/faq/faqDetail";
	}
	
	@GetMapping("/modify")
	public String modify() {
		
		return "/faq/faqModify";
	}
	
	
}
