package com.court.proj.announce;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.court.proj.admin.CourtAdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.court.proj.aplcnReg.TrialVO;
import com.court.proj.user.CourtUserDetails;

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
	String admin_id = "";
	int total = 0;

	// 모집공고 목록 페이지
	@GetMapping("announceList")
	public String announceList(Model model, AnnounceCriteria cri) {

//		// 공고 리스트
//		ArrayList<AnnounceVO> list = announceService.AnnounceList(cri);
//		model.addAttribute("list", list);
//
//		int total = announceService.getAnnTotal(cri);
//		model.addAttribute("total", total);
//
//		// 페이징 정보를 생성하여 모델에 추가
//		AnnouncePageVO announcePageVO = new AnnouncePageVO(cri, total);
//		model.addAttribute("pageVO", announcePageVO);

		return "announce/announceList";
	}

	// 모집공고 ajax list
	@GetMapping("announceListAjax")
	public ResponseEntity<ArrayList<AnnounceVO>> fclttListAjax(AnnounceCriteria cri) {

		ArrayList<AnnounceVO> list = announceService.getAnnList(cri);
		total = announceService.getAnnTotal(cri);
		AnnouncePageVO announcePageVO = new AnnouncePageVO(cri, total);

		for(AnnounceVO avo : list) {
			avo.setAnnouncePageVO(announcePageVO);
			avo.setTotal(total);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


	// 모집공고 상세 페이지
	@GetMapping("announceDetail")
	public String announceDetail(@RequestParam(name = "id") int announce_proper_num, Model model) {
		AnnounceVO alist = announceService.getAnnounceDetail(announce_proper_num);
		model.addAttribute("alist", alist);
//em.out.println(alist.toString());

		return "announce/announceDetail";
	}

	// 모집공고 수정 페이지
	@GetMapping("announceModify")
	public String announceModify(@RequestParam(name = "id") int announce_proper_num, Model model, Authentication auth) {

		CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();

		admin_id = admin.getUsername();
		
		AnnounceVO alist = announceService.getAnnounceDetail(announce_proper_num);
		model.addAttribute("alist", alist);

		AnnounceVO avo = announceService.getinfo(admin_id);
		model.addAttribute("vo", avo);
		admin_num = avo.getAdmin_proper_num();

		ArrayList<TrialVO> tlist = announceService.getTrial();
		model.addAttribute("tlist", tlist);

		return "announce/announceModify";
	}

	// 모집공고 수정 폼 요청
	@PostMapping("/announceModifyForm")
	public String announceModifyForm(@RequestParam(name = "id", required = true) int announce_proper_num, @ModelAttribute AnnounceVO vo, Model model) {

//		vo.setAdmin_proper_num(admin_num);
//		vo.setAdmin_id(admin_id);
//		vo.setAdmin_pw(admin_pw);
//		vo.setAdmin_auth(admin_auth);
//		vo.setAdmin_name(admin_name);

		vo.setAdmin_proper_num(announceService.getinfo(admin_id).getAdmin_proper_num());
		
		if (vo.getSelectType3().equals("선택")) {
			vo.setTrial_fcltt_proper_num(announceService.getTrialNum1(vo.getSelectType1(), vo.getSelectType2()));
		} else {
			vo.setTrial_fcltt_proper_num(
					announceService.getTrialNum2(vo.getSelectType1(), vo.getSelectType2(), vo.getSelectType3()));
		}

//		System.out.println(vo.toString());
		
		announceService.updateAnnounce(vo);

		return "redirect:/announce/announceList";
	}

	// 모집공고 등록 페이지
	@GetMapping("announceRegist")
	public String announceRegist(Model model, Authentication auth) {

		CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();

		admin_id = admin.getUsername();

		AnnounceVO avo = announceService.getinfo(admin_id);
		model.addAttribute("vo", avo);
		admin_num = avo.getAdmin_proper_num();

		ArrayList<TrialVO> tlist = announceService.getTrial();
		model.addAttribute("tlist", tlist);

		return "announce/announceRegist";
	}

	// 모집공고 등록 폼 요청
	@PostMapping("/announceRegistForm")
	public String announceRegistForm(@ModelAttribute AnnounceVO vo) {

		vo.setAdmin_id(admin_id);
		vo.setAdmin_proper_num(announceService.getinfo(admin_id).getAdmin_proper_num());

		if (vo.getSelectType3().equals("선택")) {
			vo.setTrial_fcltt_proper_num(announceService.getTrialNum1(vo.getSelectType1(), vo.getSelectType2()));
		} else {
			vo.setTrial_fcltt_proper_num(
					announceService.getTrialNum2(vo.getSelectType1(), vo.getSelectType2(), vo.getSelectType3()));
		}

//		System.out.println(vo.toString());
		announceService.announceRegistTB002(vo);

		return "redirect:/announce/announceList";
	}

}