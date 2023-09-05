package com.court.proj.announce;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AnnounceMapper {

	// 등록
	public int announceRegist(AnnounceVO vo);
	// 조회
	public ArrayList<AnnounceVO> getList(@Param("announce_proper_num") String admin);

}
