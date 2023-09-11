package com.court.proj.announce;

import java.util.ArrayList;

public interface AnnounceService {

	public AnnounceVO getinfo(String admin_id);

	// 등록
	public int announceRegist(AnnounceVO vo);

	// 공고 리스트 조회
	public ArrayList<AnnounceVO> getannounceList();

	// 검색기능
	public ArrayList<AnnounceVO> searchAnnounceByTitleAndContent(String keyword);

	public ArrayList<AnnounceVO> searchAnnounceByTitle(String keyword);

	public ArrayList<AnnounceVO> searchAnnounceByContent(String keyword);

	// 재판조력자 조회
	public ArrayList<AnnounceVO> getTrial();

	// 공고 등록 TB_002
	public int announceRegistTB002(AnnounceVO vo);

	// 공고 등록 TB_010
	public int announceRegistTB010(AnnounceVO vo);

	// 공고 등록 TB_015
	public int adminRegistTB015(AnnounceVO vo);

}
