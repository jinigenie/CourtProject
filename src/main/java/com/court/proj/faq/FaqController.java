package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		 System.out.println(div+"---------------------------------");
		
		/*
		 * ArrayList<FaqVO> list = faqService.getList(cri); int total =
		 * faqService.getTotal(cri); FclttPageVO PageVO = new FclttPageVO(cri, total);
		 * 
		 * System.out.println("컨트롤러 실행:" + PageVO.toString());
		 * 
		 * model.addAttribute("PageVO", PageVO); model.addAttribute("list", list);
		 */

		return "/faq/faqList";
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

		System.out.println(list.toString());
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	// FAQ 작성/수정
	@GetMapping("/modify")
	public String detail(@RequestParam("faq_proper_num") String faq_proper_num, Model model) {
		FaqVO vo = faqService.getDetail(faq_proper_num);
		model.addAttribute("vo", vo);
		return "/faq/faqModify";
	}
	// FAQ 작성/수정 Form faqModifyForm
	@PostMapping("/faqModifyForm")
	public String faqModifyForm(@ModelAttribute("vo")FaqVO vo) {
		System.out.println("=========faqModify==========");
		System.out.println(vo.toString());
		int result = faqService.faqModify(vo);

		return "redirect:/faq/faqList";
	}

	
	@GetMapping("/faqDel")
	public String faqDel(@RequestParam("faq_proper_num") String faq_proper_num) {
		System.out.println("================================");
		System.out.println("faq_proper_num ? : " + faq_proper_num);
		int result = faqService.faqDel(faq_proper_num);

		return "redirect:/faq/faqList";
	}
	
	
	// FAQ 등록페이지 진입
	@GetMapping("/regist")
	public String regist() {
		return "/faq/faqRegist";
	}
	
	
	// FAQ 등록 form
	@PostMapping("/registForm")
	public String registForm(@ModelAttribute("vo")FaqVO vo) {
		System.out.println("================================");
		System.out.println(vo.toString());
		int result = faqService.faqRag(vo);

		return "redirect:/faq/faqList";
	}


}
