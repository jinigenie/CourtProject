package com.court.proj.fcltt;

import lombok.Data;

@Data
public class FclttCriteria {

	private int page; //조회하는 페이지시작번호
	private int amount; //출력할 데이터 갯수
	
	//검색에 필요한 키워드 선언
	
	private String serchFaq_proper_num;
	private String searchCourt; //법원
	private String searchCourtName; //법원
	private String searchAct; //활동여부
	private String searchDate; // 등록날짜
	private String searchAll; // 검색내용
	private String searchContent; //검색내용
	private String searchContent2; //검색내용
	private String searchNameCode; //조력자 소분류코드
	
	// 중지신청목록에 쓰일 검색
	private String searchAccept_act_yn; // 활동상태 검색
	private String searchUser_name; // 사용자이름검색
	private String divVal;
	
	////////////////////// faq에  사용할 검색 값 
	
	//검색에 필요한 키워드 선언
	private String searchFaq_proper_num;  // faq 번호
	private String searchAdmin_proper_num; // 작성 관리자 번호
	private String searchFaq_ask_content; //질문 
	private String searchFaq_ask_comment; //답변 
	private String searchFaq_ask_date; //작성일
	
	// 공지에 쓰일 검색값
	private String serachNotice_title; //제목
	private String serachNotice_content; //내용
	
	// 기본생성자로 만들 시 기본값 : page = 1; amount = 10;
	public FclttCriteria() {
		this.page=1;
		this.amount=10;
	}

	// 기본생성자가 아니면 값을 전달 받을 수 있다
	public FclttCriteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	
	// 페이지시작을 지정하는 getter
	public int getPageStart() {
		return (page-1) * amount ;
	}

	
	
	
	
}
