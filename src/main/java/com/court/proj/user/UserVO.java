package com.court.proj.user;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	/*
	 USER_PROPER_NUM	INT auto_increment,
	 USER_ID 	VARCHAR(10) NOT NULL,
	 USER_PW 	VARCHAR(100) NOT NULL,
	 USER_NAME 	VARCHAR(10)	NOT NULL,
	 USER_RRN_F 	VARCHAR(30)	NOT NULL,
	 USER_RRN_B 	VARCHAR(30)	NOT NULL,
	 USER_EMAIL_F 	VARCHAR(50) NOT NULL,
	 USER_EMAIL_B 	VARCHAR(50) NOT NULL,
	 USER_PHONE 	VARCHAR(20)	NOT NULL,
	 USER_JOB 	VARCHAR(100)	NULL,
	 USER_AR 	VARCHAR(100)	NULL,
	 USER_AR_ZONECODE 	VARCHAR(20)	NULL,
	 USER_AR_DETAIL 	VARCHAR(200)	NULL,
	 USER_BANK 	VARCHAR(100) NOT NULL,
	 USER_BANK_ACCOUNT 	VARCHAR(100) NOT NULL,
	 USER_BANK_HOLDER 	VARCHAR(20)	NOT NULL,
	 USER_JOINDATE 	DATE default (current_date),
	 USER_DELETE_YN 	VARCHAR(1)	NOT NULL check(USER_DELETE_YN in ('Y','N')) default 'N',
     USER_EDCTN_FINAL  VARCHAR(50) DEFAULT NULL,
     USER_ROLE VARCHAR(20) DEFAULT 'USER',
	 */

	private Integer user_proper_num;
	@Pattern(regexp = "^[a-z0-9]{7,16}$", message = "7~16자의 영문 소문자, 숫자의 조합으로 작성해주세요")
	private String user_id;
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$", message = "8~16자 영문+숫자 조합으로 작성바랍니다.")
	private String user_pw;
	@Pattern(regexp = "^[가-힣]*$", message = "한글만 입력 가능합니다.")
	private String user_name;
	private String user_rrn_f;
	private String user_rrn_b;
	private String user_email_f;
	private String user_email_b;
	@Pattern(regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", message = "'-' 을 제외한 숫자 11자리로 작성바랍니다.")
	private String user_phone;
	private String user_job;
	private String user_ar;
	private String user_ar_zonecode;
	private String user_ar_detail;
	private String user_bank;
	private String user_bank_account;
	private String user_bank_holder;
	private String user_joindate;
	private String user_edctn_final;
	private String user_delete_yn;
	private String user_role;

}
