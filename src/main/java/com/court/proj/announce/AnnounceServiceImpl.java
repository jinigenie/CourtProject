package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.proj.aplcnReg.TrialVO;

@Service("announceService")
public class AnnounceServiceImpl implements AnnounceService {

	@Autowired
	private AnnounceMapper announceMapper;

	// 등록
	@Override
	public int announceRegist(AnnounceVO vo) {

		return announceMapper.announceRegistTB002(vo);
	}

	// 검색기능
	@Override
	public ArrayList<AnnounceVO> searchAnnounceTitleAndContent(String keyword) {
		return announceMapper.searchAnnounceTitleAndContent(keyword);
	}

	@Override
	public ArrayList<AnnounceVO> searchAnnounceTitle(String keyword) {
		return announceMapper.searchAnnounceTitle(keyword);
	}

	@Override
	public ArrayList<AnnounceVO> searchAnnounceContent(String keyword) {
		return announceMapper.searchAnnounceContent(keyword);
	}

	// 공고 리스트 조회
	@Override
	public ArrayList<AnnounceVO> getannounceList() {
		return announceMapper.getannounceList();
	}

	// 공고 등록 정보
	@Override
	public int announceRegistTB002(AnnounceVO vo) {
		return announceMapper.announceRegistTB002(vo);
	}

	@Override
	public AnnounceVO getinfo(String admin_id) {
		return announceMapper.getinfo(admin_id);
	}

	@Override
	public int getTrialNum1(String st1, String st2) {
		return announceMapper.getTrialNum1(st1, st2);
	}

	@Override
	public Integer getTrialNum2(String st1, String st2, String st3) {
		Integer result = announceMapper.getTrialNum2(st1, st2, st3);
		return (result != null) ? result : 0;
	}

	@Override
	public ArrayList<TrialVO> getTrial() {
		return announceMapper.getTrial();
	}

	@Override
	public TrialVO getTrialVO(int trial_fcltt_proper_num) {
		return announceMapper.getTrialVO(trial_fcltt_proper_num);
	}

	@Override
	public AnnounceVO getAnnounceDetail(int announce_proper_num) {
		return announceMapper.getAnnounceDetail(announce_proper_num);
	}

	@Override
	public AnnounceVO getAnnounceModify(AnnounceVO vo) {
		return announceMapper.getAnnounceModify(vo);
	}

	@Override
	public int getTotal() {
		return announceMapper.getTotal();
	}

	@Override
	public int updateAnnounce(AnnounceVO vo) {
		return announceMapper.updateAnnounce(vo);
	}
}