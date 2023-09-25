package com.court.proj.aplcn.util;

import lombok.Data;

@Data
public class Criteria {

	private int page; // 조회하는 페이지
	private int amount; // 데이터개수

	// 검색에 필요한 키워드를 선언
	private String searchField;
	private String searchName;
	private String searchStatus;
	private String searchContent;
	
	private String searchUserName;
	private String searchNameCode;
	private String searchCourt;
	private String aplicn_dtls_sts;
	private String user_name;
	private String trial_fcltt_clasifi_code;
	private String court_name;

	// 기본생성자로 만들어지면 1, 10 기본값이다.
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	// 기본생성자가 아니면 값을 전달 받음
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}

	// 페이지시작을 지정하는 getter
	public int getPageStart() {
		return (page - 1) * amount;
	}
}
