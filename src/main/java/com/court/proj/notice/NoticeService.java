package com.court.proj.notice;

import java.util.ArrayList;

import com.court.proj.fcltt.FclttCriteria;

public interface NoticeService {

	// 목록 불러오기 Total
	public ArrayList<NoticeVO> getList(FclttCriteria cri);
	public int getTotal(FclttCriteria cri);
	
	// 작성하기
	public int noticeReg(NoticeVO vo);
	
	// 상세보기
	public NoticeVO getDetail(String notice_proper_num);
	
	// 수정하기
	public int noticeModify(NoticeVO vo);
	
	// 삭제하기
	public int noticeDel(String notice_proper_num);
	
	
	
}
