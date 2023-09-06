package com.court.proj.fcltt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/fcltt")	
public class FclttController {
	
	@Autowired
	private FclttService fclttService;
	
	// 등재명단
	@GetMapping("/fclttList")
	public String fclttList(Model model, FclttCriteria cri) {
			
		
			ArrayList<FclttVO>list= fclttService.getList(cri);
			
			model.addAttribute("list",list);
			return "fcltt/fclttList";
	
	}
	
	
	@GetMapping("/fclttDetail")
	public String fclttDetail() {
		
		return "fcltt/fclttDetail";
	}
	@GetMapping("/fclttRegist")
	public String fclttRegist() {
		
		return "fcltt/fclttRegist";
	}
	
	@GetMapping("/pause")
	public String pause() {
		
		return "fcltt/pauseEvaluation";
	}
	
	@PostMapping("/fclttRegistForm")
	public String fclttRegistFom(FclttVO vo, RedirectAttributes ra) {
		
		System.out.println(vo.getAccept_act_yn());
		System.out.println(vo.toString());
		int result = fclttService.fclttRegist(vo);
		String msg = result == 1 ? "등록되었습니다" : "";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/fcltt/fclttList";
	}
	
	
	@PostMapping("/getfclttModal")
	public @ResponseBody ResponseEntity<ArrayList<FclttVO>>getfclttModal(@RequestBody FclttVO vo){
		ArrayList<FclttVO> list = fclttService.getFclttContent(vo.getAccept_proper_num());
		System.out.println(list.toString());
		
		return new ResponseEntity<>(list,  HttpStatus.OK);
	}
	
	
	

}
