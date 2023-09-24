package com.court.proj.announce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnounceVO {

	private AnnouncePageVO announcePageVO;

	private int announce_proper_num;
	private int admin_proper_num;
	private int trial_fcltt_proper_num;
	private String announce_title;
	private String announce_content;
	private String announce_start_date;
	private String announce_end_date;
	private String announce_first_date;
	private String announce_last_date;
	private String admin_id;
	private String admin_pw;
	private String admin_auth;
	private String admin_name;
	private String trial_fcltt_main_code;
	private String trial_fcltt_clasifi_code;
	private String trial_fcltt_sbcls_code;
	private String trial_fcltt_description;
	private int total;

	// 선택한 재판조력자 유형
	private String selectType1;
	private String selectType2;
	private String selectType3;

}
