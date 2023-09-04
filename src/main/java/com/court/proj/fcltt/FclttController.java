package com.court.proj.fcltt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/fcltt")	
public class FclttController {
	
	@Autowired
	private FclttService fclttService;
	
	// 등재명단
	@GetMapping("/fclttList")
	public String fclttList() {
		
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
		
		System.out.println(vo.toString());
		int result = fclttService.fclttRegist(vo);
		String msg = result == 1 ? "등록되었습니다" : "";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/fcltt/fclttList";
	}
	
	
	

}
