package com.court.proj.announce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announce")
public class AnnounceController {

	// 모집공고 목록 페이지
	@GetMapping("announceList")
	public String announceList() {
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
