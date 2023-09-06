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
	
	private Integer USER_PROPER_NUM; // 사용자 고유번호
	private String user_name; //유저정보
	private Integer accept_proper_num; //재판조력자 합격자 고유번호
	private String trial_fcltt_description; //재판조력자 고유번호
	private String court_name; //법원번호;
	private LocalDateTime accept_date;//선발날짜
	private String accept_etc;//기타내용
	private String accept_act_yn;//활동여부
	
	
}
