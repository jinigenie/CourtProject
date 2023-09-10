package com.court.proj.fcltt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		int total = fclttService.getTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
		
		model.addAttribute("list",list);
		model.addAttribute("FclttPageVO",FclttPageVO);
		return "fcltt/fclttList";

	}

	// 등재명단 상세보기 ajax 
	@PostMapping("/getfclttModal")
	public @ResponseBody ResponseEntity<FclttVO>getfclttModal(@RequestParam("accept_proper_num") String accept_proper_num){
		System.out.println(accept_proper_num);
		FclttVO list = fclttService.getFclttContent(accept_proper_num);
		System.out.println(list.toString());

		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	//안쓰는 페이지 (연습용)
	@GetMapping("/fclttDetail")
	public String fclttDetail() {

		return "fcltt/fclttDetail";
	}

	// 등재작성페이지
	@GetMapping("/fclttRegist")
	public String fclttRegist() {

		return "fcltt/fclttRegist";
	}

	// 중지신청 목록진입
	
	 @GetMapping("/pause") public String pause() {
	 return "fcltt/pauseEvaluation"; }
	 

	 // 목록 ajax
	@GetMapping("/pauseAjax")
	@ResponseBody
	public ResponseEntity<ArrayList<PauseVO>> pauseList(FclttCriteria cri) {
	    ArrayList<PauseVO> list = fclttService.getPauseList(cri);
	    return new ResponseEntity<>(list, HttpStatus.OK);
	}
	// 페이징 ajax 
	@GetMapping("/getTotal")
	@ResponseBody
	public ResponseEntity<FclttPageVO> getTotal(FclttCriteria cri) {
		
		int total = fclttService.getTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
	    return new ResponseEntity<>(FclttPageVO, HttpStatus.OK);
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


	@PostMapping("/pauseResultSubmit")
	public ResponseEntity<Integer>pauseResultSubmit(@RequestParam("user_proper_num") String user_proper_num,
													@RequestParam("accept_act_yn") String accept_act_yn){
		FclttVO vo = new FclttVO();
		vo.setUser_proper_num(user_proper_num);
		vo.setAccept_act_yn(accept_act_yn);
		
		System.out.println(vo.toString());
		int result = accept_act_yn.equals("Y")  ?  fclttService.setPauseY(vo) : fclttService.setPauseN(vo) ;
		System.out.println("결과: " + result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}







}
