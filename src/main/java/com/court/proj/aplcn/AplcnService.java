package com.court.proj.aplcn;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.court.proj.aplcn.util.Criteria;

public interface AplcnService {
	
	//신청자 리스트
	public ArrayList<ListVO> getList(int user_proper_num, Criteria cri);
	public int getTotal(int user_proper_num, Criteria cri); //전체 게시글 수
	
	//신청자 상세정보
	public ArrayList<ListVO> getDetails(int aplcn_dtls_proper_num); //상세
	public ListVO getDetail(int aplcn_dtls_proper_num); 
	
	//신청자 평가 (수정중)
	public int aplcnEvaluate(ListVO vo);
	
	//파일 다운로드
	public ListVO aplcnFiles(int aplcn_dtls_proper_num);
}
