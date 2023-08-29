package com.court.proj.fcltt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fcltt")	
public class FclttController {
	
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
	
	
	
	

}
