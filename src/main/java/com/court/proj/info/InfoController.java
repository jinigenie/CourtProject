package com.court.proj.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {

	@GetMapping("/info")
	public String info() {
		
		return "info/info";
	}
	
	@GetMapping("/infoProcess")
	public String infoProcess() {
		
		return "info/infoProcess";
	}
	
}
