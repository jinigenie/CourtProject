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

	int trial_pn = 0;
	int admin_num = 0;

	// 모집공고 목록 페이지
	@GetMapping("announceList")
	public String announceList(Model model) {

		ArrayList<AnnounceVO> list = announceService.getannounceList();

		model.addAttribute("list", list);

		return "announce/announceList";
	}

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

		AnnounceVO avo = announceService.getinfo(id);
		model.addAttribute("vo", avo);
		admin_num = avo.getAdmin_proper_num();

		TrialVO tvo = announceService.getTrialVO(trial_pn);
		model.addAttribute("trial", tvo);

		ArrayList<TrialVO> alist = announceService.getTrial();
		model.addAttribute("alist", alist);

		System.out.println(alist.toString());

		return "announce/announceRegist";
	}

	// 모집공고 등록 폼 요청
	@PostMapping("/announceRegistForm")
	public String announceRegistForm(@ModelAttribute AnnounceVO vo, Model model) {

		vo.setAdmin_proper_num(admin_num);


		if (vo.getSelectType3() == null || vo.getSelectType3().isEmpty()) {
			vo.setTrial_fcltt_proper_num(announceService.getTrialNum1(vo.getSelectType1(), vo.getSelectType2()));
		} else {
			vo.setTrial_fcltt_proper_num(
					announceService.getTrialNum2(vo.getSelectType1(), vo.getSelectType2(), vo.getSelectType3()));
		}

		model.addAttribute("vo", vo);

		System.out.println(vo.toString());

		return "redirect:/announce/announceList";
	}

}
