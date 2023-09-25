package com.court.proj.aplcn;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

import com.court.proj.aplcn.util.Criteria;
import com.court.proj.aplcn.util.PageVO;

@Controller
@RequestMapping("/aplcn")
public class AplcnController {

	@Autowired
	@Qualifier("aplcnService")
	private AplcnService aplcnService;

	/*@Value("${s3downloadPath}")
	private String s3downloadPath;*/

	
	// 신청자 리스트
	@GetMapping("/aplcnList")
	public String list(Model model, Criteria cri) {
		
		ArrayList<ListVO> list = aplcnService.getList(cri);

		int total = aplcnService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);

		model.addAttribute("total", total);
		model.addAttribute("vo", list);
		model.addAttribute("pageVO", pageVO);

		return "aplcn/aplcnList";
	}

	// 신청자 상세정보
	@GetMapping("/aplcnDetails")
	public String Details(@RequestParam("aplcn_dtls_proper_num") Integer aplcn_dtls_proper_num, Model model) {

		ListVO vo1 = aplcnService.getDetail(aplcn_dtls_proper_num);
		System.out.println(vo1);
		// ArrayList<ListVO> vo = aplcnService.getDetails(aplcn_dtls_proper_num);
		model.addAttribute("vo1", vo1);
		model.addAttribute("edcnList", aplcnService.getEdctnList(aplcn_dtls_proper_num));
		model.addAttribute("carerList", aplcnService.getCarerList(aplcn_dtls_proper_num));
		model.addAttribute("crtfcList", aplcnService.getCrtfcList(aplcn_dtls_proper_num));
		
		int sum = 0;
		ListVO vo = aplcnService.getScore(aplcn_dtls_proper_num);
		if (vo != null) {
		sum += vo.getAll_carer_score();
		sum += vo.getJrsdc_carer_score();
		sum += vo.getOffice_score();
		sum += vo.getPersonality_score();
		sum += vo.getInterview_score();
		sum += vo.getCertificate_score();
		sum += vo.getEvaluate_score();
		sum += vo.getJudge_recom_score();
		model.addAttribute("score", sum);
		}
		
		/*List<String> linkList = new ArrayList<String>();

		List<FileVO> fileList = aplcnService.getFileList(aplcn_dtls_proper_num);

		try { // encoededString이 고정주소/유저아이디/+ 여기에

			for (FileVO v : fileList) {
				String downloadPath = s3downloadPath + "/" + vo1.getUser_id() + "/"
						+ URLEncoder.encode(v.getFile_path(), StandardCharsets.UTF_8.toString());
				linkList.add(downloadPath);
				System.out.println(v.getFile_path());
			}
			model.addAttribute("linkList", linkList);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/

		return "aplcn/aplcnDetails";

	}

	// 신청자 평가하기
	@GetMapping("/aplcnEvaluate")
	public String aplcnEvaluate(@RequestParam("aplcn_dtls_proper_num") Integer aplcn_dtls_proper_num, Model model) {

		ListVO vo = aplcnService.getDetail(aplcn_dtls_proper_num);
		model.addAttribute("vo", vo);
		return "aplcn/aplcnEvaluate";
	}

	// 신청자 평가 후 (상세정보로 이동)
	@PostMapping("/evaluateForm")
	public String evaluateForm(ListVO vo, RedirectAttributes ra, Model model) {
		vo.setAdmin_proper_num("1");
		int result = aplcnService.aplcnEvaluate(vo);
		ListVO vo1 = aplcnService.getDetail(vo.getAplcn_dtls_proper_num());
		model.addAttribute("vo", vo1);
		String msg = result == 1 ? "등재가 완료되었습니다." : "등재를 완료하세요! ";
		ra.addFlashAttribute("result", result);
		ra.addFlashAttribute("msg", msg);

		return "redirect:/aplcn/aplcnDetails?aplcn_dtls_proper_num=" + vo.getAplcn_dtls_proper_num();
	}

	// 신청자 상태변환1 (서류반려)
	@PostMapping("/aplcnReject")
	public String aplcnReject(ListVO vo, RedirectAttributes ra) {
		vo.setAplicn_dtls_sts("서류반려");
		int result = aplcnService.aplcnReject(vo);
		// String msg = result == 1 ? "서류를 반려하였습니다." : "서류 반려 실패! 관리자에게 문의하세요.";
		// ra.addFlashAttribute("msg", msg1);

		return "redirect:/aplcn/aplcnDetails?aplcn_dtls_proper_num=" + vo.getAplcn_dtls_proper_num();
	}

	// 신청자 상태변환2 (평가완료)
	@PostMapping("/aplcnCompleted")
	public String aplcnCompleted(ListVO vo, RedirectAttributes ra) {
		vo.setAplicn_dtls_sts("평가완료");
		vo.setAdmin_proper_num("1");
		int result = aplcnService.aplcnCompleted(vo);
		//String msg = result == 1 ? "평가를 완료하였습니다." : "평가 완료 실패! 관리자에게 문의하세요.";
		ra.addFlashAttribute("result", result);

		return "redirect:/aplcn/aplcnEvaluate?aplcn_dtls_proper_num=" + vo.getAplcn_dtls_proper_num();
	}

	//신청자 상태 심사중으로
	@PostMapping("updateSts")
	public @ResponseBody ResponseEntity<Integer> updatests(@RequestParam("aplcn_dtls_proper_num") String dtlsnum){
		
			int result = aplcnService.updateSts(dtlsnum);
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
