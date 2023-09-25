package com.court.proj.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

		ArrayList<NoticeVO> list = noticeService.getList(cri);

		int total = noticeService.getTotal(cri);
		FclttPageVO pageVO = new FclttPageVO(cri, total);

		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		return "notice/noticeList";
	}

	// 공지 상세 페이지
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(name = "notice_proper_num") String notice_proper_num, Model model) {

		NoticeVO vo = noticeService.getDetail(notice_proper_num);
		model.addAttribute("vo", vo);

		return "notice/noticeDetail";
	}

	// 공지 수정 페이지
	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam(name = "notice_proper_num") String notice_proper_num, Model model) {

		NoticeVO vo = noticeService.getDetail(notice_proper_num);
		model.addAttribute("vo", vo);
		return "notice/noticeModify";
	}

	// 공지 수정 form
	@PostMapping("/noticeModify")
	public String noticeModify(NoticeVO vo, Authentication auth, RedirectAttributes ra) {
		CourtAdminDetails admin = (CourtAdminDetails) auth.getPrincipal();

		// admin_proper_num 불러와야함 !
		vo.setAdmin_proper_num("1");
		int result = noticeService.noticeModify(vo);
		String msg = result == 1 ? "등로 되었습니다" : "등록 실패";
		ra.addFlashAttribute("msg", msg);
		return "redirect:/notice/noticeList";
	}

	// 공지 등록 페이지
	@GetMapping("/noticeRegist")
	public String noticeRegist(Model model, Authentication auth) {
		CourtAdminDetails admin = (CourtAdminDetails) auth.getPrincipal();
		String admin_proper_num = "1";
		model.addAttribute("admin_proper_num", admin_proper_num);

		return "notice/noticeRegist";
	}

	// 공지 등록 form
	@PostMapping("/notelistForm")
	public String notelistForm(NoticeVO vo, Authentication auth, RedirectAttributes ra) {
		CourtAdminDetails admin = (CourtAdminDetails) auth.getPrincipal();

		// admin_proper_num 불러와야함 !
		vo.setAdmin_proper_num("1");
		int result = noticeService.noticeReg(vo);
		String msg = result == 1 ? "등로 되었습니다" : "등록 실패";
		ra.addFlashAttribute("msg", msg);

		return "redirect:/notice/noticeList";
	}
	
	
	//공지 삭제
	@GetMapping("/noticeDel")
	public String noticeDel(@RequestParam(name = "notice_proper_num")String notice_proper_num) {
		int result = noticeService.noticeDel(notice_proper_num);
		
		return "redirect:/notice/noticeList";
	}
	

}
