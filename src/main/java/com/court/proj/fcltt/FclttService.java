package com.court.proj.fcltt;

import java.util.ArrayList;


public interface FclttService {

	// 조력자 등재
	public int fclttRegist(FclttVO vo);
	
	// 조력자명단조회
	public ArrayList<FclttVO> getList(FclttCriteria cri);  //조회  페이징하기 (criteria 객체생성)
	public int getTotal(FclttCriteria cri);
	//명단에서 상세보기 ajax
	public ArrayList<FclttVO> getFclttContent(int accept_proper_num);
	
}
