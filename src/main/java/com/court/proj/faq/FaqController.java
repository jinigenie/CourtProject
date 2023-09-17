package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.court.proj.fcltt.FclttCriteria;
import com.court.proj.fcltt.FclttPageVO;
import com.court.proj.fcltt.FclttVO;

@Controller
@RequestMapping("/faq")
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	// FAQ 리스트
	@GetMapping("/faqList")
	public String faqLlist(FclttCriteria cri) {
		
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
	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<ArrayList<FaqVO>> list(FclttCriteria cri) {
		
		ArrayList<FaqVO> list = faqService.getList(cri);
		
		int total = faqService.getTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
		for (FaqVO FaqVO : list) {
			FaqVO.setFclttPageVO(FclttPageVO);
		}
		
		System.out.println("컨트롤러 실행:" + FclttPageVO.toString());
		

		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	// FAQ 작성/수정
	@GetMapping("/regist")
	public String detail() {
		
		return "/faq/faqRegist";
	}
	

	
	
}
