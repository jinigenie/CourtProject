package com.court.proj.fcltt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FclttVO {
	
	private FclttPageVO fclttPageVO;
	private String user_proper_num; // 사용자 고유번호 1tb
	private String user_name; //유저정보 1tb
	private String user_phone; //유저 전화번호 1tb
	private String user_email_f; //유저 이메일 앞 1tb
	private String user_email_b; //유저 이메일 도메인 1tb
	
	private String aplcn_dtls_proper_num; //신청자 번호
	private String accept_proper_num; //재판조력자 합격자 고유번호 14 tb
	
	private String trial_fcltt_description; //재판조력자 고유번호 
	private String trial_fcltt_main_code; //재판조력자 고유번호 
	
	private String court_proper_num; //법원 고유번호
	private String court_name; //법원이름;
	private String court_region; //법원분류;
	private String accept_date;//선발날짜
	private String accept_etc;//기타내용
	private String accept_act_yn;//활동여부
	private String court_proper1;//희망법원1
	private String court_proper2;//희망법원2
	
	
	private String trial_fcltt_clasifi_code; //조력자분류
	private String trial_fcltt_sbcls_code; //조력자 이름
	
	private String edctn_school_name; //학교이름 6tb
	private String edctn_major; //전공 6tb
	private String edctn_degree; //학위 6tb
	private String company_name;// 회사명 7tb
	private String carer_type;// 회사명 7tb
	private String work_department;// 회사부서 7tb
	private String work_start_date;// 근무기간1 7tb
	private String work_end_date;// 근무기간2 7tb
	private String crtfc_type;// 자격증 8tb
	private String issue_agency;// 자격증 발급기관 8tb
	private Integer trial_fcltt_proper_num;// 조력자 분류번호
	private String trial_num; // 재판번호
	private String attendance_date; // 재판출석일
	private String act_complete_yn; // 재판 완료여부
	
	
	
	
}
