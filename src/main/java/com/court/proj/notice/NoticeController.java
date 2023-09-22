package com.court.proj.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.court.proj.fcltt.FclttCriteria;
import com.court.proj.fcltt.FclttPageVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

		@Autowired
		private NoticeService noticeService;
	
		// 공지 목록 페이지
		@GetMapping("/noticeList")
		public String noticeList(FclttCriteria cri, Model model) {
			
			ArrayList<NoticeVO>list = noticeService.getList(cri);
			
			int total = noticeService.getTotal(cri);
			  FclttPageVO pageVO = new FclttPageVO(cri, total);
			
			model.addAttribute("list",list);
			model.addAttribute("pageVO",pageVO);
			System.out.println(total);
			System.out.println(pageVO.toString());
			return "notice/noticeList";
		}
		
		// 공지 상세 페이지
		@GetMapping("/noticeDetail")
		public String noticeDetail() {
			return "notice/noticeDetail";
		}
		
		// 공지 수정 페이지
		@GetMapping("/noticeModify")
		public String noticeModify() {
			return "notice/noticeModify";
		}
		
		// 공지 등록 페이지
		@GetMapping("/noticeRegist")
		public String noticeRegist() {
			return "notice/noticeRegist";
		}
		
	
}
