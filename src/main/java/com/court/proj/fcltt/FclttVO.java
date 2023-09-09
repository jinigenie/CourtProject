package com.court.proj.fcltt;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FclttVO {
	
	private Integer user_proper_num; // 사용자 고유번호 1tb
	private String user_name; //유저정보 1tb
	private String accept_proper_num; //재판조력자 합격자 고유번호 14 tb
	private String trial_fcltt_description; //재판조력자 고유번호 
	private String court_name; //법원이름;
	private String court_region; //법원분류;
	private LocalDateTime accept_date;//선발날짜
	private String accept_etc;//기타내용
	private String accept_act_yn;//활동여부
	private String trial_fcltt_clasifi_code; //조력자분류
	private String trial_fcltt_sbcls_code; //조력자 이름
	private String edctn_school_name; //학교이름 6tb
	private String edctn_major; //전공 6tb
	private String edctn_degree; //학위 6tb
	private String company_name;// 회사명 7tb
	private String carer_type;// 경력구분 7tb
	private String crtfc_type;// 자격증 8tb
	private Integer trial_fcltt_proper_num;
	
	
}
