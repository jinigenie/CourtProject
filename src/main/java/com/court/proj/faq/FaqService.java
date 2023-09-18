package com.court.proj.faq;

import java.util.ArrayList;

import com.court.proj.fcltt.FclttCriteria;


public interface FaqService {

	// faq 리스트 . 토탈 불러오기 
	public ArrayList <FaqVO> getList(FclttCriteria cri);
	public int getTotal(FclttCriteria cri);
	
	// 글 수정하기 
	public FaqVO getDetail(String faq_proper_num);
	
	// 글 삭제하기
	public int faqDel(String faq_proper_num);
	
}
