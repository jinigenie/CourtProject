package com.court.proj.faq;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.court.proj.fcltt.FclttCriteria;

@Mapper
public interface FaqMapper {
	
	// faq 리스트 . 토탈 불러오기 
	public ArrayList <FaqVO> getList(FclttCriteria cri);
	public int getTotal(FclttCriteria cri);
}
