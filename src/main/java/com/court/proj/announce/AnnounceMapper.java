package com.court.proj.announce;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnnounceMapper {

	// 등록
	public int announceRegist(AnnounceVO vo);
	
	// 조회
	public ArrayList<AnnounceVO> getannounceList();

}
