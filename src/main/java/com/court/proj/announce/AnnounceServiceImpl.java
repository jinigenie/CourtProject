package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("announceService")
public class AnnounceServiceImpl implements AnnounceService {

	@Autowired
	private AnnounceMapper announceMapper;

	// 등록
	@Override
	public int announceRegist(AnnounceVO vo) {
		// TB_002 테이블에 공고 정보 삽입
		int resultTB002 = announceMapper.announceRegistTB002(vo);

		// TB_010 테이블에 재판조력자 정보 삽입
		int resultTB010 = announceMapper.announceRegistTB010(vo);

		// TB_015 테이블에 관리자 정보 삽입
		int resultTB015 = announceMapper.adminRegistTB015(vo);

		// 모든 테이블에 성공적으로 데이터가 삽입되었을 때 1을 반환, 그렇지 않으면 0을 반환
		if (resultTB002 > 0 && resultTB010 > 0 && resultTB015 > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// 검색기능
	@Override
	public ArrayList<AnnounceVO> searchAnnounceByTitleAndContent(String keyword) {
		return announceMapper.searchAnnounceByTitleAndContent(keyword);
	}

	@Override
	public ArrayList<AnnounceVO> searchAnnounceByTitle(String keyword) {
		return announceMapper.searchAnnounceByTitle(keyword);
	}

	@Override
	public ArrayList<AnnounceVO> searchAnnounceByContent(String keyword) {
		return announceMapper.searchAnnounceByContent(keyword);
	}

	// 공고 리스트 조회
	@Override
	public ArrayList<AnnounceVO> getannounceList() {
		return announceMapper.getannounceList();
	}

	// 재판조력자 조회
	@Override
	public ArrayList<AnnounceVO> getTrial() {
		return announceMapper.getTrial();
	}

	@Override
	public int announceRegistTB002(AnnounceVO vo) {
		return announceMapper.announceRegistTB002(vo);
	}

	@Override
	public int announceRegistTB010(AnnounceVO vo) {
		return announceMapper.announceRegistTB010(vo);
	}

	@Override
	public int adminRegistTB015(AnnounceVO vo) {
		return announceMapper.adminRegistTB015(vo);
	}

	@Override
	public AnnounceVO getinfo(String admin_id) {
		return announceMapper.getinfo(admin_id);
	}

}
