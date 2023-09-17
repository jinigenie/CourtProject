package com.court.proj.fcltt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/fcltt")
public class FclttController {

	@Autowired
	private FclttService fclttService;

	// 등재명단페이지 진입
	@GetMapping("/fclttList")
	public String fclttList(FclttCriteria cri) {

		return "fcltt/fclttList";
	}

	
	// 안쓰는 페이지 (연습용)
	@GetMapping("/fclttDetail")
	public String fclttDetail() {
		return "fcltt/fclttDetail";
	}
	

	// 등재작성페이지
	@GetMapping("/fclttRegist")
	public String fclttRegist(Model model) {
		/*
		 * public String fclttRegist(@RequestParam("user_proper_num") String
		 * user_proper_num,
		 * 
		 * @RequestParam("court_proper1") String court_proper1,
		 * 
		 * @RequestParam("court_proper2") String court_proper2, Model model) {
		 */
		String EX = "1";
		String court_proper1 = "수원지방법원";
		String court_proper2 = "인천지방법원";
		FclttVO vo = fclttService.getDetail(EX);
		String court_proper_num1 = fclttService.getDetail1(court_proper1);
		String court_proper_num2 = fclttService.getDetail2(court_proper2);
		
		model.addAttribute("vo",vo);
		model.addAttribute("court_proper_num1",court_proper_num1);
		model.addAttribute("court_proper_num2",court_proper_num2);
		
		System.out.println(vo.toString());
		
		return "fcltt/fclttRegist";
	}

	// 명단 등록하기
	@PostMapping("/fclttRegistForm")
	public String fclttRegistFom(FclttVO vo, RedirectAttributes ra) {

		System.out.println(vo.getUser_proper_num());
		System.out.println(vo.getTrial_fcltt_proper_num());
		System.out.println(vo.getCourt_proper_num());
		System.out.println(vo.getAccept_etc());
		/*
		 * System.out.println(vo.getAccept_act_yn()); System.out.println(vo.toString());
		 * int result = fclttService.fclttRegist(vo); String msg = result == 1 ?
		 * "등록되었습니다" : ""; ra.addFlashAttribute("msg", msg);
		 */

		return "redirect:/fcltt/fclttList";
	}

	// Pause
	// -------------------------------------------------------------------------------------------
	// 중지신청 목록진입

	@GetMapping("/pause")
	public String pause() {
		return "fcltt/pauseEvaluation";
	}

	

}


