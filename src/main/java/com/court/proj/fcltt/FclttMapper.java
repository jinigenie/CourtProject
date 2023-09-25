package com.court.proj.fcltt;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FclttMapper {
	
	// 조력자 등재페이지 진입시 조회 1
	public FclttVO getDetail(String user_proper_num);
	// 조력자 등재페이지 진입시 조회 2(희망법원2에 대한 법원분류번호)
	public String getDetail1(String court_proper1);
	// 조력자 등재페이지 진입시 조회 3(희망법원3에 대한 법원분류번호)
	public String getDetail2(String court_proper2);
	
	// 조력자 등재
	public int fclttRegist(FclttVO vo);
	public int fclttRegist2(String aplcn_dtls_proper_num);

	// 조력자 조회
	public ArrayList<FclttVO> getList(@Param("cri")FclttCriteria cri);  //조회  페이징하기 (criteria 객체생성)

	public int getTotal(@Param("cri") FclttCriteria cri);
	
	//------------------------------------------------------------------
	//명단에서 상세보기 ajax 1. 기본정보
	public FclttVO  getFclttContent1(String accept_proper_num);
	
	//명단에서 상세보기 ajax 2. 학력정보
	public ArrayList<FclttVO> getFclttContent2(String user_proper_num);
	
	//명단에서 상세보기 ajax 3. 재판이력
	public ArrayList<FclttVO> getFclttContent3(String user_proper_num);
	
	//명단에서 상세보기 ajax 4. 자격증 
	public ArrayList<FclttVO> getFclttContent4(String user_proper_num);
	
	//명단에서 상세보기 ajax 5. 경력
	public ArrayList<FclttVO> getFclttContent5(String user_proper_num);
	
	//------------------------------------------------------------------
	
	//중지/ 활동 신청 리스트 
	public ArrayList<PauseVO> getPauseList(@Param("cri")FclttCriteria cri);
	public int getPauseTotal(@Param("cri") FclttCriteria cri);
	
	//중지/활동신청 승인
	public int setPauseY(FclttVO vo);
	public int setPauseN(FclttVO vo);
	

	
}
