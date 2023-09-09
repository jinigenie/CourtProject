package com.court.proj.main;

import java.util.ArrayList;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.faq.FaqVO;
import com.court.proj.notice.NoticeVO;

public interface MainService {
	
	ArrayList<AnnounceVO> getAnnList();
	ArrayList <FaqVO> getFaqList();
	ArrayList<NoticeVO> getNoticeList();
	
}
