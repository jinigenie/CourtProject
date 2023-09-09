package com.court.proj.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.court.proj.announce.AnnounceService;
import com.court.proj.announce.AnnounceVO;
import com.court.proj.faq.FaqService;
import com.court.proj.faq.FaqVO;
import com.court.proj.notice.NoticeVO;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private FaqService faqService;
	@Autowired
	private AnnounceService announceService;
	@Autowired
	private MainService mainService;

	// 메인화면
	@GetMapping("/main")
	public String main(Model model) {
		ArrayList<AnnounceVO> list1 = mainService.getAnnList();
		ArrayList<NoticeVO>list2= mainService.getNoticeList();
		ArrayList<FaqVO>list3= mainService.getFaqList();

		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		
		return "/main/mainPage";
	}
	

	
}
