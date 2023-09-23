package com.court.proj.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.court.proj.admin.CourtAdminDetails;
import com.court.proj.announce.AnnounceVO;
import com.court.proj.aplcnReg.TrialVO;
import com.court.proj.fcltt.FclttCriteria;
import com.court.proj.fcltt.FclttPageVO;
import com.court.proj.user.CourtUserDetails;

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
		public String noticeRegist(Model model,Authentication auth) {
			CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();
			String admin_proper_num = "1";
			model.addAttribute("admin_proper_num", admin_proper_num);
			
			return "notice/noticeRegist";
		}
		
		//공지 등록 form
		@PostMapping("/notelistForm")
		public String notelistForm(NoticeVO vo, Authentication auth) {
			CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();
			
			// admin_proper_num 불러와야함 !
			vo.setAdmin_proper_num("1");
			int result = noticeService.noticeReg(vo);
			
			return "redirect:/notice/noticeList";
		}
		
		
		
		
		
		
		
		
		
		
		
	
}
