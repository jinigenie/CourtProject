package com.court.proj.fcltt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fclttService")
public class FclttServiceImple implements FclttService {
	
	@Autowired
	private FclttMapper fclttMapper;
	
	//조력자 등재
	@Override
	public int fclttRegist(FclttVO vo) {
		return fclttMapper.fclttRegist(vo);
	}

	// 조력자명단조회
	@Override
	public ArrayList<FclttVO> getList(FclttCriteria cri) {
		return fclttMapper.getList(cri);
	}
	// 조력자명단조회 페이징
	@Override
	public int getTotal(FclttCriteria cri) {
		return fclttMapper.getTotal(cri);
	}

	@Override
	public ArrayList<FclttVO> getFclttContent(int accept_proper_num) {
		return fclttMapper.getFclttContent(accept_proper_num);
	}

}
