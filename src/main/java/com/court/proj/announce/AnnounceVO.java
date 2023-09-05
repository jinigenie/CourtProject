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

//	 재판조력자 선발 공고내역
//	CREATE TABLE  TB_002  (
//		 ANNOUNCE_PROPER_NUM 	INT	NOT NULL primary KEY auto_increment,
//	     ADMIN_PROPER_NUM 	INT	NOT NULL,
//		 FOREIGN KEY(ADMIN_PROPER_NUM) REFERENCES TB_015(ADMIN_PROPER_NUM),
//	     TRIAL_FCLTT_PROPER_NUM INT	NOT NULL,
//		 FOREIGN KEY(TRIAL_FCLTT_PROPER_NUM) REFERENCES TB_010(TRIAL_FCLTT_PROPER_NUM),
//	     ANNOUNCE_TITLE 	VARCHAR(100) NOT NULL,
//		 ANNOUNCE_CONTENT 	VARCHAR(1500) NOT NULL,
//		 ANNOUNCE_START_DATE 	DATE NOT NULL,
//		 ANNOUNCE_END_DATE 	DATE NOT NULL,
//		 ANNOUNCE_FIRST_DATE 	DATE default (current_date),
//		 ANNOUNCE_LAST_DATE 	DATE default (current_date)	
//	);
	
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
	
	
	
}
