package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.court.proj.aplcnReg.TrialVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/announce")
public class AnnounceController {

	@Autowired
	@Qualifier("announceService")
	private AnnounceService announceService;

	int trial_fcltt_proper_num = 0;
	int admin_num = 1;
	String admin_id = "admin1";
	String admin_pw = "admin1";
	String admin_auth = "seoul";
	String admin_name = "이순신1234";
	
	// 모집공고 목록 페이지
	@GetMapping("announceList")
	public String announceList(Model model) {
		
		// 공고 리스트
		ArrayList<AnnounceVO> list = announceService.getannounceList();
		model.addAttribute("list", list);
		
		int total = announceService.getTotal();
		model.addAttribute("total", total);
		
		return "announce/announceList";
	}

	// 검색기능
	@GetMapping("searchAnnounce")
	public String searchAnnounce(@RequestParam(name = "searchField", defaultValue = "0") int searchField,
			@RequestParam(name = "qString", defaultValue = "") String qString, Model model) {
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
	public String announceDetail(@RequestParam(name = "id") int announce_proper_num, Model model) {
		AnnounceVO alist = announceService.getAnnounceDetail(announce_proper_num);
		model.addAttribute("alist", alist);
//		System.out.println("공고 상세 정보 : " + alist.toString());

		return "announce/announceDetail";
	}

	// 모집공고 수정 페이지

	@GetMapping("announceModify")
	public String announceModify(@RequestParam(name = "id", required = true) int announce_proper_num, Model model) {

	    AnnounceVO alist = announceService.getAnnounceDetail(announce_proper_num);
	    model.addAttribute("alist", alist);
		
		AnnounceVO avo = announceService.getinfo(admin_id);
		model.addAttribute("vo", avo);
		admin_num = avo.getAdmin_proper_num();

		ArrayList<TrialVO> tlist = announceService.getTrial();
		model.addAttribute("tlist", tlist);


		return "announce/announceModify";
	}

	@PostMapping("/announceModifyForm")
	public String announceModifyForm(@ModelAttribute AnnounceVO vo, Model model) {

		vo.setAdmin_proper_num(admin_num);
		vo.setAdmin_id(admin_id);
		vo.setAdmin_pw(admin_pw);
		vo.setAdmin_auth(admin_auth);
		vo.setAdmin_name(admin_name);

		if (vo.getSelectType3().equals("선택")) {
			vo.setTrial_fcltt_proper_num(announceService.getTrialNum1(vo.getSelectType1(), vo.getSelectType2()));
		} else {
			vo.setTrial_fcltt_proper_num(
					announceService.getTrialNum2(vo.getSelectType1(), vo.getSelectType2(), vo.getSelectType3()));
		}

		System.out.println(vo.toString());

		announceService.announceRegistTB002(vo);
		announceService.updateAnnounce(vo);

		return "redirect:/announce/announceList";
	}

	// 모집공고 등록 페이지
	@GetMapping("announceRegist")
	public String announceRegist(Model model) {

//		log.info("sdfsdf");
		AnnounceVO avo = announceService.getinfo(admin_id);
		model.addAttribute("vo", avo);
		admin_num = avo.getAdmin_proper_num();

		ArrayList<TrialVO> tlist = announceService.getTrial();
		model.addAttribute("tlist", tlist);

		System.out.println(tlist.toString());

		return "announce/announceRegist";
	}

	// 모집공고 등록 폼 요청
	@PostMapping("/announceRegistForm")
	public String announceRegistForm(@ModelAttribute AnnounceVO vo, Model model) {

		vo.setAdmin_proper_num(admin_num);
		vo.setAdmin_id(admin_id);
		vo.setAdmin_pw(admin_pw);
		vo.setAdmin_auth(admin_auth);
		vo.setAdmin_name(admin_name);

		if (vo.getSelectType3().equals("선택")) {
			vo.setTrial_fcltt_proper_num(announceService.getTrialNum1(vo.getSelectType1(), vo.getSelectType2()));
		} else {
			vo.setTrial_fcltt_proper_num(
					announceService.getTrialNum2(vo.getSelectType1(), vo.getSelectType2(), vo.getSelectType3()));
		}

		System.out.println(vo.toString());

		announceService.announceRegistTB002(vo);

		return "redirect:/announce/announceList";
	}

}