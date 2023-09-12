package com.court.proj.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActiveVO {
	
	/*
    ACT_PROPER_NUM     INT primary KEY auto_increment,
    TRIAL_NUM 		   INT NULL,
	ACCEPT_PROPER_NUM  INT NOT NULL,
    CHOSEN_DATE        DATE NOT NULL,
    ATTENDANCE_DATE    DATE NULL,
    ACT_COMPLETE_YN    VARCHAR(1) NOT NULL DEFAULT 'N'
	*/

	private int act_proper_num;
	private int trial_num;
	private String chosen_date;
	private String attendance_date;
	private String act_complete_yn;

}
