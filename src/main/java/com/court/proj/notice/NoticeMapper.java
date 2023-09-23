package com.court.proj.notice;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.court.proj.fcltt.FclttCriteria;

@Mapper
public interface NoticeMapper {

	// 목록 불러오기 Total
	public ArrayList<NoticeVO> getList(@Param("cri")FclttCriteria cri);
	public int getTotal(@Param("cri")FclttCriteria cri);
	
	// 작성하기
	public int noticeReg(NoticeVO vo);
	
	// 상세보기
	public NoticeVO getDetail(String notice_proper_num);
	
	// 수정하기
	public int noticeModify(NoticeVO vo);
	
	// 삭제하기
	public int noticeDel(String notice_proper_num);
	
}
