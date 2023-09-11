package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/announce")
public class AnnounceController {

	@Autowired
	@Qualifier("announceService")
	private AnnounceService announceService;

	// 모집공고 목록 페이지

	@GetMapping("announceList")
	public String announceList(Model model) {

		ArrayList<AnnounceVO> list = announceService.getannounceList();

		model.addAttribute("list", list);

		return "announce/announceList";
	}

	@GetMapping("searchAnnounce")
	public String searchAnnounce(@RequestParam(name = "searchField", defaultValue = "0") int searchField,
	                             @RequestParam(name = "qString", defaultValue = "") String qString,
	                             Model model) {
	    ArrayList<AnnounceVO> list = new ArrayList<>();

	    if (searchField == 0) {
	        
	        list = announceService.searchAnnounceByTitleAndContent(qString);
	    } else if (searchField == 1) {
	        
	        list = announceService.searchAnnounceByTitle(qString);
	    } else if (searchField == 2) {
	        
	        list = announceService.searchAnnounceByContent(qString);
	    }

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
	public String announceRegist(Model model) {

//		log.info("sdfsdf");

		String id = "admin1";
		
		ArrayList<AnnounceVO> alist = announceService.getTrial();
		model.addAttribute("alist", alist);
		
		return "announce/announceRegist";
	}

	// 모집공고 등록 폼 요청
	@PostMapping("/announceRegistForm")
	public String announceRegistForm(Model model, AnnounceVO vo) {
		
		int result = announceService.announceRegist(vo);

	    if (result == 1) {
	        return "redirect:/announce/announceList";
	    } else {
	        model.addAttribute("errorMessage", "등록에 실패했습니다.");
	        return "announce/announceRegist";
	    }
	}

	
	
}
