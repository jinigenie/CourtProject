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

@Controller
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
	
	// 모집공고 등록 폼 요청
	@PostMapping("/announceRegistForm")
	public String announceRegistForm(
	    @RequestParam("announce_title") String announceTitle,
	    @RequestParam("announce_content") String announceContent,
	    @RequestParam("announce_start_date") String startDate,
	    @RequestParam("announce_end_date") String endDate,
	    @RequestParam("trial_fcltt_main_code") String trialfclttMaincode,
	    @RequestParam("trial_fcltt_clasifi_code") String trialfclttClasificode,
	    @RequestParam("trial_fcltt_sbcls_code") String trialfclttSbclscode,
	    
	    RedirectAttributes ra) {

	    AnnounceVO vo = AnnounceVO.builder()
	        .announce_title(announceTitle)
	        .announce_content(announceTitle)
	        .announce_content(startDate)
	        .announce_end_date(endDate)
	        .trial_fcltt_main_code(trialfclttMaincode)
	        .trial_fcltt_clasifi_code(trialfclttClasificode)
	        .trial_fcltt_sbcls_code(trialfclttSbclscode)
	        .build();

	    try {
	        int result = announceService.announceRegist(vo);

	        if (result > 0) {
	            ra.addFlashAttribute("공고등록 성공", "모집공고가 성공적으로 등록되었습니다.");
	        } else {
	            ra.addFlashAttribute("공고등록 오류", "모집공고 등록 중 오류가 발생하였습니다.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        ra.addFlashAttribute("공고등록 오류", "모집공고 등록 중 오류가 발생하였습니다.");
	    }

	    return "redirect:/announce/announceList";
	}

	
}
