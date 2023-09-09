package com.court.proj.faq;

import lombok.Data;

@Data
public class FaqCriteria {
	
	private int page; //조회하는 페이지시작번호
	private int amount; //출력할 데이터 갯수

	
	//검색에 필요한 키워드 선언
	private String searchFaq_proper_num;  // faq 번호
	private String searchAdmin_proper_num; // 작성 관리자 번호
	private String searchFaq_ask_content; //질문 
	private String searchFaq_ask_comment; //답변 
	private String searchFaq_ask_date; //작성일
	
	
	
	// 기본생성자로 만들 시 기본값 : page = 1; amount = 10;
	public FaqCriteria() {
		this.page=1;
		this.amount=10;
	}

	// 기본생성자가 아니면 값을 전달 받을 수 있다
	public FaqCriteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	
	// 페이지시작을 지정하는 getter
	public int getPageStart() {
		return (page-1) * amount ;
	}

	
}
