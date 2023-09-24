package com.court.proj.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.court.proj.aplcn.util.Criteria;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	MypageService mypageService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/main")
	public String mypage(Model model, Authentication auth) {
		
		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		
		int user_proper_num = user.getUser_proper_num();
		UserVO userVO = mypageService.getUser(user_proper_num);
		model.addAttribute("userVO", userVO);
		System.out.println(userVO.toString());
		
		return "mypage/main";
	}

	@GetMapping("/modify")
	public String modify(Model model, Authentication auth) {
		
		
		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		
		int user_proper_num = user.getUser_proper_num();
		UserVO userVO = mypageService.getUser(user_proper_num);
		model.addAttribute("userVO", userVO);
		System.out.println(userVO.toString());
		
		return "mypage/modify";
	}
	
	@GetMapping("/history")
	public String history(Model model, HistoryCriteria cri, Authentication auth) {

		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		
		int user_proper_num = user.getUser_proper_num();
		ArrayList<ActiveVO> list = mypageService.getHistory(user_proper_num, cri);
		
		int total = mypageService.historyTotal(user_proper_num, cri);
		HistoryPageVO pageVO = new HistoryPageVO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "mypage/history";
	}
	
	@GetMapping("/pause")
	public String pause(Model model, Authentication auth, RedirectAttributes rra) {
		
		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		int user_proper_num = user.getUser_proper_num();
		
		if( !mypageService.pauseAccess(user_proper_num) ) {
			String msg = "재판조력자가 아닙니다.";
			rra.addFlashAttribute("msg", msg);
			return "redirect:/mypage/main";
		}
		
		PauseDataVO vo = mypageService.getPause(user_proper_num);
		model.addAttribute("vo", vo);
		
		return "mypage/pause";
	}
	
	@GetMapping("/status")
	public String status(Model model, Authentication auth) {
		
		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		
		int user_proper_num = user.getUser_proper_num();
		ArrayList<MypageStatusVO> list = mypageService.getStatus(user_proper_num);
		model.addAttribute("list", list);
		System.out.println(list.size());
		int size = list.size();
		model.addAttribute("size",size);
		return "mypage/status";
	}


	@PostMapping("/deleteForm")
	public String del(UserVO vo) {
		
		int result = mypageService.deleteUpdate(vo);
		
		return "redirect:../main/";
	}

	
	@PostMapping("/modifyForm")
	public String modifyForm(UserVO vo, RedirectAttributes rra, Authentication auth) {
		
		String newpw = bCryptPasswordEncoder.encode(vo.getUser_pw());
		vo.setUser_pw(newpw);
		
		int result = mypageService.modifyUpdate(vo);
		String msg = result == 1? "회원정보가 변경되었습니다." : "변경실패. 관리자에게 문의하세요";
		rra.addFlashAttribute("msg", msg);
		return "redirect:/mypage/main";
	}

	
	@PostMapping("/pauseForm")
	public String pauseForm(PauseDataVO vo, RedirectAttributes rra) {
		
		int result = mypageService.regPause(vo);
		String msg = result == 1? "신청되었습니다." : "신청실패. 관리자에게 문의하세요";
		rra.addFlashAttribute("msg", msg);
		System.out.println(result);
		return "redirect:/mypage/main";
	}
	
	@PostMapping("/checkPw")
	public @ResponseBody ResponseEntity<Boolean> checkpw(@RequestParam("checkpw") String pw, Authentication auth){
		CourtUserDetails user = (CourtUserDetails)auth.getPrincipal();
		String rawpw = user.getPassword();
		boolean bool = bCryptPasswordEncoder.matches(pw, rawpw);
		return new ResponseEntity<>(bool, HttpStatus.OK);
	}
}
