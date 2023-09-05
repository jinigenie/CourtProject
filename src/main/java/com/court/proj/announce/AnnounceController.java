package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announce")
public class AnnounceController {

	@Autowired
	@Qualifier("announceService")
	private AnnounceService announceService;
	
	// 모집공고 목록 페이지
	@GetMapping("announceList")
	public String announceList(Model model) {
		
		String admin = "admin";
		
		ArrayList<AnnounceVO> list = announceService.getList(admin);
		
		model.addAttribute("list", list);
		
		return "announce/announceList";
	}
	
	// 모집공고 상세 페이지
	@GetMapping("announceDetail")
	public String announceDetail() {
		return "announce/announceDetail";
	}
	
	// 모집공고 수정 페이지
	@GetMapping("announceModify")
	public String announceModify() {
		return "announce/announceModify";
	}
	
	// 모집공고 등록 페이지
	@GetMapping("announceRegist")
	public String announceRegist() {
		return "announce/announceRegist";
	}
	
	
	
}
