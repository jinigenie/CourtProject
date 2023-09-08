package com.court.proj.announce;

import java.util.ArrayList;


public interface AnnounceService {

	// 등록
	public int announceRegist(AnnounceVO vo);
	
	// 조회
	public ArrayList<AnnounceVO> getannounceList();
	
}
