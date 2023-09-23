package com.court.proj.fcltt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PauseVO {
	
	private FclttPageVO fclttPageVO;
	private String accept_pause;  // tb14_2  중지상태 
	private Integer user_proper_num;  // tb14_2 사용자번호
	private String admin_name;  // 관리자 이름
	private String pause_status;  // tb14_2 중지처리현황
	private String accept_proper_num;  // tb14_2 재판조력자 합겨번호
	private String pause_start_date;  // tb14_2 중지시작일
	private String pause_end_date;  // tb14_2 중지끝나는일
	private String pause_submit_date;  // tb14_2 중지시넝일
	private String accept_pause_etc;  // tb14_2 중지사유
	private String user_name;  // tb1 사용자이름
	private String accept_act_yn;  // tb14 활동상태
	
	
	
}
