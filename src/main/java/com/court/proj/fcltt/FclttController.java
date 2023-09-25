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

import com.court.proj.aplcn.util.EmailService;

@Controller
@RequestMapping("/fcltt")
public class FclttController {

	@Autowired
	private FclttService fclttService;

	@Autowired
	private EmailService emailService;

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
	public String fclttRegist(@RequestParam("user_proper_num") String user_proper_num, Model model) {
		// public String fclttRegist( Model model) {

		// String user_proper_num ="2";
		FclttVO vo = fclttService.getDetail(user_proper_num);

		String court_proper1 = vo.getCourt_proper1();
		String court_proper2 = vo.getCourt_proper2();


		String court_proper_num1 = fclttService.getDetail1(court_proper1);
		String court_proper_num2 = fclttService.getDetail2(court_proper2);

		model.addAttribute("vo", vo);
		model.addAttribute("court_proper_num1", court_proper_num1);
		model.addAttribute("court_proper_num2", court_proper_num2);

		return "fcltt/fclttRegist";
	}

	// 명단 등록하기
	@PostMapping("/fclttRegistForm")
	public String fclttRegistFom(FclttVO vo, RedirectAttributes ra) {
		
		System.out.println("vo정보 ========================================= : "+vo.toString());
		// 이메일 발송
		String email1= vo.getUser_email_f() ;
		String email2= vo.getUser_email_b() ;
		String to = email1+"@"+email2;
		// 수신자 이메일 주소
		String subject = vo.getUser_name()+"님의 재판조력자 신청결과 입니다"; // 이메일 제목
		String emailContent = 
				"<html>" +
						"<body>" +
						"<div class=''>" +
						"<div class='aHl'></div>" +
						"<div id=':qa' tabindex='-1'></div>" +
						"<div id=':ts' class='ii gt' jslog='20277; u014N:xr6bB; 1:WyIjdGhyZWFkLWY6MTc3NzYwMTc1MTgwNDM3NjEwMiIsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsW11d; 4:WyIjbXNnLWY6MTc3NzYwMTc1MTgwNDM3NjEwMiIsbnVsbCxbXSxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsbnVsbCxudWxsLG51bGwsW11d;'>" +
						"<div id=':tt' class='a3s aiL '>" +
						"<div class='adM'></div>" +
						"<div>" +
						"<div class='adM'></div>" +
						"<div style='background:#ffffff;margin:0;padding:0;font-family:AppleSDGothicNeo-Regular,Malgun Gothic," +
						"'\\00b9d1\\00c740\\00ace0\\00b515','\\00b3cb\\00c6c0',dotum,sans-serif'>" +
						"<div class='adM'></div>" +
						"<div style='background:#ffffff;margin:0 auto;padding:0;width:100%;max-width:600px;letter-spacing:-1px;box-sizing:border-box'>" +
						"<div class='adM'></div>" +
						"<table width='100%' style='margin:0;padding:0;max-width:600px' border='0' cellspacing='0' cellpadding='0'>" +
						"<tbody>" +
						"<tr>" +
						"<td height='12'></td>" +
						"</tr>" +
						"<tr>" +
						"<td style='background:#f6f7fb;border-radius:20px 20px 0 0;padding:0 16px'>" +
						"<table width='100%' style='margin:0;padding:0' border='0' cellspacing='0' cellpadding='0'>" +
						"<tbody>" +
						"<tr>" +
						"<td height='48'></td>" +
						"</tr>" +
						"<tr>" +
						"<td style='background:#fff;border-radius:10px;padding:24px 40px 48px'>" +
						"<table width='100%' style='margin:0;padding:0;border='0' cellspacing='0' cellpadding='0'>" +
						"<tbody>" +
						"<tr>" +
						"<td align='center' style='padding:0 0 16px;border-bottom:1px solid #dee1ea;color:#222;font-size:20px;font-weight:bold;line-height:24px;letter-spacing:-0.5px'>" +
						"재판조력자 신청결과" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style='padding:0;text-align:center'>" +
						"<table width='100%' style='margin:0;padding:0;border='0' cellspacing='0' cellpadding='0'>" +
						"<tbody>" +
						"<tr>" +
						"<td align='left' style='margin:0;padding:0'>" +
						"<div style='padding:24px 0 16px;border-bottom:1px solid #dee1ea;color:#222;font-size:13px;line-height:18px'>" +
						"<p style='margin:0;padding:16px 0 0;color:rgb(128, 128, 128);font-size:12px;line-height:18px;letter-spacing:-0.5px;text-align:left'>" +
						"<br />" +
						vo.getUser_name()+"님<br /><br /><br />" +
						"지원하신 공고의 평가 결과 합격되었습니다.<br /><br />" +
						"사이트내에 <a style='font-size:14px; font-weight: 700; text-decoration: none;color:rgb(128, 128, 128);' href='http://localhost:8585/user/mypage'>" +
						"마이페이지</a>에서 등재 여부를 확인하실 수 있습니다.<br /><br />" +
						"당신의 뛰어난 능력으로, 재판과정에서 공정성을 유지하는 데 기여하실 것을 기대합니다.<br /><br />" +
						"감사합니다.<br /><br /><br />" +
						"</p>" +
						"</div>" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</div>" +
						"</tr>" +
						"<tr>" +
						"<td bgcolor='#8d919e'>" +
						"<table style='margin:0;padding:0;width:100%' border='0' cellspacing='0' cellpadding='0'>" +
						"<tbody>" +
						"<tr>" +
						"<td style='margin:0;padding:16px;text-align:left'>" +
						"<p style='margin:0;padding:0;color:#e6e9f2;font-size:11px;line-height:16px;letter-spacing:-1px'>" +
						"<a style='text-decoration: none;color:#e6e9f2;' href='http://localhost:8585/main/main'>재판조력자 홈페이지<br></a>" +
						"주소 : 서울특별시 강남구 테헤란로 7길 7 재판조력자 서비스센터" +
						"</p>" +
						"<p style='margin:0;padding:0;color:#e6e9f2;font-size:11px;line-height:16px;letter-spacing:-1px'>" +
						"Copyright(c)Ministry of Employment and Labor. All rights reserved.</p>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td height='48'></td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</div>" +
						"</div>" +
						"<img height='0' width='0' border='0' " +
						"src='https://ci6.googleusercontent.com/proxy/H15_w6u57QdeZqZW-zxbDp0YvoJ8AzQnsJVoW18Txn3_u3GRoPKeZ9yg2Atrz-Rh4pdrPi0IB7VkWhjMYkRNrX0eMS7mxJTFLrhxBNRl3AET4h15piDS5-x74BXaUQlWKZi8=s0-d-e1-ft#http://eventmailtrack.saramin.co.kr:80/9I-112635I-41E-8272822389I-4uPmuPzeI-4I-3'" +
						"class='CToWUd' data-bit='iit'>" +
						"</div>" +
						"<div class='yj6qo'></div>" +
						"<div class='adL'>" +
						"</div>" +
						"</div>" +
						"</div>" +
						"<div class='hi'></div>" +
						"</body>" +
						"</html>";
		emailService.sendEmail(to, subject, emailContent);
		

		int result = fclttService.fclttRegist(vo);
		int result2 = fclttService.fclttRegist2(vo.getAplcn_dtls_proper_num());
		String msg = result == 1 ? "등록되었습니다" : "";
		ra.addFlashAttribute("msg", msg);

		return "redirect:/aplcn/aplcnList";
	}

	// Pause
	// -------------------------------------------------------------------------------------------
	// 중지신청 목록진입

	@GetMapping("/pause")
	public String pause() {
		return "fcltt/pauseEvaluation";
	}

}
