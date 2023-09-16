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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.court.proj.aplcn.ListVO;

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

	// 등재명단 ajax목록
//	@GetMapping("/fclttListAjax")
//	@ResponseBody
//	public ResponseEntity<ArrayList<FclttVO> > fclttListAjax( FclttCriteria cri) {
//		ArrayList<FclttVO>list= fclttService.getList(cri);
//		System.out.println(list.toString());
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	@GetMapping("/fclttListAjax")
	@ResponseBody
	public ResponseEntity<ArrayList<FclttVO>> fclttListAjax(FclttCriteria cri) {

		ArrayList<FclttVO> list = fclttService.getList(cri);

		int total = fclttService.getTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
		for (FclttVO fclttVO : list) {
			fclttVO.setFclttPageVO(FclttPageVO);
		}
		/*
		 * FclttPageVO.setPage(cri.getPage()); FclttPageVO.setAmount(cri.getAmount());
		 */

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/*
	 * // 페이징 ajax
	 * 
	 * @GetMapping("/fclttTotal")
	 * 
	 * @ResponseBody public ResponseEntity<FclttPageVO> fclttTotal(FclttCriteria
	 * cri) {
	 * 
	 * int total = fclttService.getTotal(cri); FclttPageVO FclttPageVO = new
	 * 
	 * FclttPageVO(cri, total); return new ResponseEntity<>(FclttPageVO,
	 * HttpStatus.OK);
	 */
	// }

	// 등재명단 상세보기 ajax
	@PostMapping("/getfclttModal")
	public @ResponseBody ResponseEntity<Map<String, Object>> getfclttModal(
			@RequestParam("accept_proper_num") String accept_proper_num,
			@RequestParam("user_proper_num") String user_proper_num) {

		Map<String, Object> map = new HashMap<>();
		map.put("content1", fclttService.getFclttContent1(accept_proper_num));
		map.put("content2", fclttService.getFclttContent2(user_proper_num));
		map.put("content3", fclttService.getFclttContent3(user_proper_num));
		map.put("content4", fclttService.getFclttContent4(user_proper_num));
		map.put("content5", fclttService.getFclttContent5(user_proper_num));

		System.out.println(map.get("content1"));

		return new ResponseEntity<>(map, HttpStatus.OK);
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

	/*
	 * // 중지, 활동신청 목록 불러오기 ajax
	 * 
	 * @GetMapping("/pauseAjax")
	 * 
	 * @ResponseBody public ResponseEntity<ArrayList<PauseVO>>
	 * pauseList(FclttCriteria cri) { ArrayList<PauseVO> list =
	 * fclttService.getPauseList(cri); return new ResponseEntity<>(list,
	 * HttpStatus.OK); }
	 * 
	 * 
	 * // 페이징 ajax
	 * 
	 * @GetMapping("/getPauseTotal")
	 * 
	 * @ResponseBody public ResponseEntity<FclttPageVO> getPauseTotal(FclttCriteria
	 * cri) {
	 * 
	 * int total = fclttService.getPauseTotal(cri); FclttPageVO FclttPageVO = new
	 * FclttPageVO(cri, total); return new ResponseEntity<>(FclttPageVO,
	 * HttpStatus.OK); }
	 */

	// 중지, 활동신청 목록 불러오기 ajax
	@GetMapping("/pauseAjax")
	@ResponseBody
	public ResponseEntity<ArrayList<PauseVO>> pauseList(FclttCriteria cri) {
		ArrayList<PauseVO> list = fclttService.getPauseList(cri);

		int total = fclttService.getPauseTotal(cri);
		FclttPageVO FclttPageVO = new FclttPageVO(cri, total);
	

		for (PauseVO PauseVO : list) {
			PauseVO.setFclttPageVO(FclttPageVO);
			System.out.println(PauseVO.toString());
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
	
	// 승인처리 ajax 컨트롤러
	@PostMapping("/pauseResultSubmit")
	public ResponseEntity<Integer> pauseResultSubmit(@RequestParam("accept_proper_num") String accept_proper_num,
			@RequestParam("accept_act_yn") String accept_act_yn) {
		FclttVO vo = new FclttVO();
		vo.setAccept_proper_num(accept_proper_num);
		vo.setAccept_act_yn(accept_act_yn);

		int result = accept_act_yn.equals("Y") ? fclttService.setPauseY(vo) : fclttService.setPauseN(vo);
		System.out.println("결과: " + result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}


