package com.court.proj.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminVO {
	/*
	 * TABLE  TB_015  (
	 ADMIN_PROPER_NUM 	INT	NOT NULL primary KEY auto_increment,
	 ADMIN_ID 	VARCHAR(20) NOT NULL,
	 ADMIN_PW 	VARCHAR(20)	NOT NULL,
	 ADMIN_AUTH 	VARCHAR(10)	NOT NULL,
     ADMIN_NAME VARCHAR(30) NOT NULL
	 */
	private Integer admin_proper_num;
	private String admin_id;
	private String admin_pw;
	private String admin_auth;
	private String admin_name;
}
