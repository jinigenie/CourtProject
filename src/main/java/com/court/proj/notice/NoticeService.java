package com.court.proj.notice;

import java.util.ArrayList;

import com.court.proj.fcltt.FclttCriteria;

public interface NoticeService {

	// 목록 불러오기 Total
	public ArrayList<NoticeVO> getList(FclttCriteria cri);
	public int getTotal(FclttCriteria cri);
	
	
	
	
	
	
	
	
}
