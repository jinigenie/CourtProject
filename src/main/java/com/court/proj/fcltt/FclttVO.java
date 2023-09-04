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
	
	private Integer accept_proper_num; //재판조력자 합격자 고유번호
	private Integer USER_PROPER_NUM; // 사용자 고유번호
	private Integer trial_fcltt_proper_num; //재판조력자 고유번호
	private Integer court_proper_num; //법원 고유번호
	private LocalDateTime accept_date;//선발날짜
	private String accept_etc;//기타내용
	private String accept_act_yn;//활동여부
}
