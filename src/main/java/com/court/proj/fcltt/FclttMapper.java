package com.court.proj.fcltt;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FclttMapper {
	// 조력자 등재
	public int fclttRegist(FclttVO vo);

}
