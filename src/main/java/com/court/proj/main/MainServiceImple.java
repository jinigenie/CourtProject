package com.court.proj.main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.faq.FaqVO;
import com.court.proj.notice.NoticeVO;

@Service("mainService")
public class MainServiceImple implements MainService {
	@Autowired
	private MainMapper mainMapper;

	@Override
	public ArrayList<AnnounceVO> getAnnList() {
		return mainMapper.getAnnList();
	}

	@Override
	public ArrayList<FaqVO> getFaqList() {
		return mainMapper.getFaqList();
	}

	@Override
	public ArrayList<NoticeVO> getNoticeList() {
		return mainMapper.getNoticeList();
	} 

	
}
