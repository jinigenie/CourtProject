package com.court.proj.announce;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("announceService")
public class AnnounceServiceImpl implements AnnounceService{

	
	@Autowired
	private AnnounceMapper announceMapper;

	// 등록
	@Override
	public int announceRegist(AnnounceVO vo) {
		return announceMapper.announceRegist(vo);
	}

	// 조회
	@Override
	public ArrayList<AnnounceVO> getList(String announce_proper_num) {
		return announceMapper.getList(announce_proper_num);
	}
	
}
