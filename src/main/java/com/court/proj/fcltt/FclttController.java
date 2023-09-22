package com.court.proj.fcltt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
    // 등재ㅁ명단 ajax 목록
    @GetMapping("/fclttListAjax")
    public ResponseEntity<ArrayList<FclttVO>> fclttListAjax(FclttCriteria cri) {
        ArrayList<FclttVO> list = fclttService.getList(cri);
        int total = fclttService.getTotal(cri);
        FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
        for (FclttVO fclttVO : list) {
            fclttVO.setFclttPageVO(FclttPageVO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // 등재명단 상세보기 ajax
    @PostMapping("/getfclttModal")
    public ResponseEntity<Map<String, Object>> getfclttModal(
            @RequestParam("accept_proper_num") String accept_proper_num,
            @RequestParam("user_proper_num") String user_proper_num) {
    	
    	System.out.println("상세보기 컨트롤러");
        Map<String, Object> map = new HashMap<>();
        map.put("content1", fclttService.getFclttContent1(accept_proper_num));
        map.put("content2", fclttService.getFclttContent2(user_proper_num));
        map.put("content3", fclttService.getFclttContent3(user_proper_num));
        map.put("content4", fclttService.getFclttContent4(user_proper_num));
        map.put("content5", fclttService.getFclttContent5(user_proper_num));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


	// 등재작성페이지
	@GetMapping("/fclttRegist")
//	 public String fclttRegist(@RequestParam("user_proper_num") String user_proper_num, Model model) {
		public String fclttRegist( Model model) {
		
		String user_proper_num ="1";
		FclttVO vo = fclttService.getDetail(user_proper_num);
		
		String court_proper1 = vo.getCourt_proper1();
		String court_proper2 = vo.getCourt_proper2();
		
		System.out.println("user_proper_num: " + user_proper_num + ", court_proper1: "+ court_proper1 + ", court_proper2: " + court_proper1);
		
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


