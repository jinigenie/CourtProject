package com.court.proj.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	BCryptPasswordEncoder encode;
	
	
	@GetMapping("/regist")
	public String adminReg(Authentication auth) {
		
		
		System.out.println(auth);
		
		//System.out.println( ((AdminVO)auth.getPrincipal()).toString() );
		
		return "admin/adminRegist";
	}
	
	@PostMapping("/registForm")
	public String adminRegistForm(AdminVO vo) {
		System.out.println(vo.toString());
		
		String pw = encode.encode(vo.getAdmin_pw());
		vo.setAdmin_pw(pw);
		String role = "ROLE_"+vo.getAdmin_auth();
		vo.setAdmin_auth(role);
		System.out.println(vo.toString());
		
		
		return "redirect:/admin/list";
	}
	
	@GetMapping("/list")
	public String adminList() {
		
		return "admin/adminList";
	}
	
	@GetMapping("/login")
	public String login() {
		return "admin/adminLogin";
	}
	
	@PostMapping("/checkDuplicateUsername")
	public ResponseEntity<Boolean> checkid(@RequestParam("adminid") String adminid){
		
		boolean bool = false;
		int re = adminService.checkId(adminid);
		if (re == 0) {
			bool = true;
		}
		
		
		return new ResponseEntity<Boolean>(bool, HttpStatus.OK);
	}
	
	
}
