package com.court.proj.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageMapper mypageMapper;

	@Override
	public UserVO getUser(int user_proper_num) {
		return mypageMapper.getUser(user_proper_num);
	}

	@Override
	public int deleteUpdate(UserVO vo) {
		return mypageMapper.deleteUpdate(vo);
	}

	@Override
	public int modifyUpdate(UserVO vo) {
		return mypageMapper.modifyUpdate(vo);
	}

	@Override
	public ArrayList<ActiveVO> getHistory(int user_proper_num, HistoryCriteria cri) {
		return mypageMapper.getHistory(user_proper_num, cri);
	}

	@Override
	public int historyTotal(int user_proper_num, HistoryCriteria cri) {
		return mypageMapper.historyTotal(user_proper_num, cri);
	}

	@Override
	public ArrayList<MypageStatusVO> getStatus(int user_proper_num) {
		return mypageMapper.getStatus(user_proper_num);
	}

	@Override
	public ArrayList<MypageStatusVO> getDocu(int aplcn_dtls_proper_num) {
		return mypageMapper.getDocu(aplcn_dtls_proper_num);
	}

	@Override
	public int regPause(PauseDataVO vo) {
		return mypageMapper.regPause(vo);
	}

	@Override
	public PauseDataVO getPause(int user_proper_num) {
		return mypageMapper.getPause(user_proper_num);
	}




	





}
