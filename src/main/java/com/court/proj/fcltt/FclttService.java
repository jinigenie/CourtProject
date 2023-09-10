package com.court.proj.fcltt;

import java.util.ArrayList;


public interface FclttService {

	// 조력자 등재
	public int fclttRegist(FclttVO vo);
	
	// 조력자명단조회ㄹ
	public ArrayList<FclttVO> getList(FclttCriteria cri);  //조회  페이징하기 (criteria 객체생성)
	public int getTotal(FclttCriteria cri);
	
	//명단에서 상세보기 ajax
	public FclttVO getFclttContent(String accept_proper_num);
	
	//중지/ 활동 신청 리스트 
	public ArrayList<PauseVO> getPauseList(FclttCriteria cri);
	public int getPauseTotal(FclttCriteria cri);
	
	//중지/활동신청 승인
	public int setPauseY(FclttVO vo);
	public int setPauseN(FclttVO vo);
	
}
