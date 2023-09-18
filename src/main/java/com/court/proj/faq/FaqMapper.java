package com.court.proj.faq;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.court.proj.fcltt.FclttCriteria;

@Mapper
public interface FaqMapper {
	
	// faq 리스트 . 토탈 불러오기 
	public ArrayList <FaqVO> getList(FclttCriteria cri);
	public int getTotal(FclttCriteria cri);

	// 글 수정하기 진입시 해당글 조회
	public FaqVO getDetail(String faq_proper_num);
	
	// 글 수정하기
	public int faqModify(FaqVO vo);
	
	// 글 삭제하기
	public int faqDel(String faq_proper_num);
	
	// faq 글 등록하기
	public int faqRag(FaqVO vo); 
}
