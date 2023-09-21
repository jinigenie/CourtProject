package com.court.proj.aplcn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.court.proj.aplcn.util.Criteria;
import com.court.proj.aplcn.util.PageVO;

@Controller
@RequestMapping("/aplcn")
public class AplcnController {

	@Autowired
	@Qualifier("aplcnService")
	private AplcnService aplcnService;

	// 신청자 리스트
	@GetMapping("/aplcnList")
	public String list(Model model, Criteria cri) {
		System.out.println(cri + "========================");
		ArrayList<ListVO> list = aplcnService.getList(cri);

		int total = aplcnService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);

		model.addAttribute("total", total);
		model.addAttribute("vo", list);
		model.addAttribute("pageVO", pageVO);

		System.out.println(pageVO.toString());
		System.out.println(list.toString());

		return "aplcn/aplcnList";
	}

	// 신청자 상세정보
	@GetMapping("/aplcnDetails")
	public String Details(@RequestParam("aplcn_dtls_proper_num") Integer aplcn_dtls_proper_num, Model model) {

		ListVO vo1 = aplcnService.getDetail(aplcn_dtls_proper_num);
		System.out.println("aaaaaaaa" + vo1.getUser_proper_num());

		System.out.println("logggggggggggggg:" + aplcn_dtls_proper_num);
		ArrayList<ListVO> vo = aplcnService.getDetails(aplcn_dtls_proper_num);

		model.addAttribute("vo1", vo1);
		model.addAttribute("vo", vo);

		System.out.println(vo1.toString());
		System.out.println(vo.toString());
		return "aplcn/aplcnDetails";

		// ResultMAP으로 ORM 처리 or
		// 재정렬 1대N G/S 모델 2개 (복수는 리스트에 다시 담는다, 1 데이터는 vo에 나가고)

	}

	// 신청자 상태변환 (수정중)
//    @GetMapping("/aplcnDetails2")
//    public String Details2(@RequestParam("user_proper_num") Integer user_proper_num, @RequestParam("aplicn_dtls_sts") String aplicn_dtls_sts) {
//    	
//    	ListVO vo = aplcnService.aplcnReject(user_proper_num);
//    	return "redirect:/aplcn/aplcnList";
//    }

	// 신청자 평가하기
	@GetMapping("/aplcnEvaluate")
	public String aplcnEvaluate(@RequestParam("aplcn_dtls_proper_num") Integer aplcn_dtls_proper_num, Model model) {
		System.out.println("logggggggggggggg:" + aplcn_dtls_proper_num);

		ListVO vo = aplcnService.getDetail(aplcn_dtls_proper_num);
		model.addAttribute("vo", vo);
		return "aplcn/aplcnEvaluate";
	}

	// 신청자 평가 후 (상세정보로 이동)
	@PostMapping("/evaluateForm")
	public String evaluateForm(ListVO vo, RedirectAttributes ra, Model model) {
		// System.out.println("logggggggggggggg:" + vo.getAplcn_dtls_proper_num());
		int result = aplcnService.aplcnEvaluate(vo);
		ListVO vo1 = aplcnService.getDetail(vo.getAplcn_dtls_proper_num());
		model.addAttribute("vo", vo1);
		String msg = result == 1 ? "등재가 완료되었습니다." : "등재를 완료하세요! ";
		ra.addFlashAttribute("result", result);
		ra.addFlashAttribute("msg", msg);

		return "redirect:/aplcn/aplcnDetails?aplcn_dtls_proper_num=" + vo.getAplcn_dtls_proper_num();
	}

	// 서비스 -> 맵퍼 -> sts 서류반려
	// int -> 결과 성공1 실패0
	// void
	// user_proper_num or aplcn_dtls_proper_num
	
	//신청자 상태변환1 (서류반려)
	@PostMapping("/aplcnReject")
	public String aplcnReject(ListVO vo, @RequestParam("user_proper_num") String user_proper_num,
								@RequestParam("aplicn_dtls_sts") String aplicn_dtls_sts, RedirectAttributes ra) {
		
		int result = aplcnService.aplcnReject(vo);
		String msg1 = result == 1 ? "서류를 반려하였습니다." : "서류 반려 실패! 관리자에게 문의하세요.";
		
		ra.addFlashAttribute("msg", msg1);

		return "redirect:/aplcn/aplcnList";
	}
	
	//신청자 상태변환2 (평가완료)
	@PostMapping("/aplcnCompleted")
	public String aplcnCompleted(ListVO vo, @RequestParam("user_proper_num") String user_proper_num,
								@RequestParam("aplicn_dtls_sts") String aplicn_dtls_sts, RedirectAttributes ra) {

		int result = aplcnService.aplcnCompleted(vo);
		String msg2 = result == 1 ? "평가를 완료하였습니다." : "평가 완료 실패! 관리자에게 문의하세요.";
		
		ra.addFlashAttribute("msg", msg2);

		return "redirect:/aplcn/aplcnDetails";
	}

}
