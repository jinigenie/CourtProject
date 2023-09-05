package com.court.proj.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

		// 공지 목록 페이지
		@GetMapping("noticeList")
		public String noticeList() {
			return "notice/noticeList";
		}
		
		// 공지 상세 페이지
		@GetMapping("noticeDetail")
		public String noticeDetail() {
			return "notice/noticeDetail";
		}
		
		// 공지 수정 페이지
		@GetMapping("noticeModify")
		public String noticeModify() {
			return "notice/noticeModify";
		}
		
		// 공지 등록 페이지
		@GetMapping("noticeRegist")
		public String noticeRegist() {
			return "notice/noticeRegist";
		}
		
	
}
