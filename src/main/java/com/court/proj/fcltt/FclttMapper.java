package com.court.proj.fcltt;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FclttMapper {
	// 조력자 등재
	public int fclttRegist(FclttVO vo);

	// 조력자 조회
	public ArrayList<FclttVO> getList(@Param("cri")FclttCriteria cri);  //조회  페이징하기 (criteria 객체생성)

	public int getTotal(@Param("cri") FclttCriteria cri);
	

	//명단에서 상세보기 ajax
	public FclttVO getFclttContent(String accept_proper_num);
}
