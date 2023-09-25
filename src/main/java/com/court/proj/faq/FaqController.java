package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.court.proj.admin.CourtAdminDetails;
import com.court.proj.fcltt.FclttCriteria;
import com.court.proj.fcltt.FclttPageVO;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@Autowired
	private FaqService faqService;

	// FAQ 리스트
	@GetMapping("/faqList")
	public String faqLlist(@RequestParam(value = "divVal", required = false) String divVal, RedirectAttributes rs ,FclttCriteria cri) {
	
		cri.setDivVal(divVal);
		var div =cri.getDivVal();
		rs.addFlashAttribute("div", div);
		
		/*
		 * ArrayList<FaqVO> list = faqService.getList(cri); int total =
		 * faqService.getTotal(cri); FclttPageVO PageVO = new FclttPageVO(cri, total);
		 * 
		 * System.out.println("컨트롤러 실행:" + PageVO.toString());
		 * 
		 * model.addAttribute("PageVO", PageVO); model.addAttribute("list", list);
		 */

		return "faq/faqList";
	}

	// FAQ 리스트
	@GetMapping("/faqListAjax")
	@ResponseBody
	public ResponseEntity<ArrayList<FaqVO>> list(@RequestParam(value = "divVal", required = false) String divVal ,FclttCriteria cri) {
		ArrayList<FaqVO> list = faqService.getList(cri);

		int total = faqService.getTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
		for (FaqVO FaqVO : list) {
			FaqVO.setFclttPageVO(FclttPageVO);
		}

		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	// FAQ 수정페이지 진입 
	@GetMapping("/modify")
	public String detail(@RequestParam("faq_proper_num") String faq_proper_num, Model model) {
		FaqVO vo = faqService.getDetail(faq_proper_num);
		model.addAttribute("vo", vo);
		
		
		return "faq/faqModify";
	}
	
	
	// FAQ 수정 Form faqModifyForm
	@PostMapping("/faqModifyForm")
	public String faqModifyForm(@ModelAttribute("vo")FaqVO vo, Authentication auth, RedirectAttributes ra) {
		CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();
		int result = faqService.faqModify(vo);
		String modifyMSG = result == 1? "수정 되었습니다" : "수정 실패";
		ra.addFlashAttribute("modifyMSG", modifyMSG);
		
		return "redirect:/faq/faqList";
	}

	
	@GetMapping("/faqDel")
	public String faqDel(@RequestParam("faq_proper_num") String faq_proper_num, RedirectAttributes ra) {
		int result = faqService.faqDel(faq_proper_num);
		return "redirect:/faq/faqList";
	}
	
	
	// FAQ 등록페이지 진입
	@GetMapping("/regist")
	public String regist(Model model,Authentication auth) {
		CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();
		String admin_proper_num = "1";
		model.addAttribute("admin_proper_num", admin_proper_num);
		return "faq/faqRegist";
	}
	
	
	// FAQ 등록 form
	@PostMapping("/registForm")
	public String registForm(FaqVO vo, Authentication auth, RedirectAttributes ra) {
	
		CourtAdminDetails admin = (CourtAdminDetails)auth.getPrincipal();
		// admin_proper_num 불러와야함 !
		vo.setAdmin_proper_num("1");
		int result = faqService.faqRag(vo);
		String regMSG = result == 1? "등로 되었습니다" : "등록 실패";
		ra.addFlashAttribute("regMSG", regMSG);
		
		return "redirect:/faq/faqList";
	}


}
