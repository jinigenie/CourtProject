package com.court.proj.announce;

import lombok.Data;

@Data
public class AnnounceCriteria {

		private int page; // 조회하는 페이지
		private int amount; // 데이터개수

		// 검색에 필요한 키워드를 선언
		private String selectedValue;	//선택한 분류
		private String search_field;	//검색조건
		private String search_cont; 	//검색어
		private String start_date;		//기간검색 시작날짜
		private String end_date;		//기간검색 끝날짜

		private String searchName;
		private String searchFcltt;
		private String searchStatus;
		private String searchContent;
		
		private String searchUserName;
		private String searchNameCode;
		private String searchCourt;
		private String aplicn_dtls_sts;

		// 기본생성자로 만들어지면 1, 10 기본값이다.
		public AnnounceCriteria() {
			this.page = 1;
			this.amount = 10;
		}

		// 기본생성자가 아니면 값을 전달 받음
		public AnnounceCriteria(int page, int amount) {
			this.page = page;
			this.amount = amount;
		}

		// 페이지시작을 지정하는 getter
		public int getPageStart() {
			return (page - 1) * amount;
		}
	
}
