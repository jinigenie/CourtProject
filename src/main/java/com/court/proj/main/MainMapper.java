package com.court.proj.main;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.faq.FaqVO;
import com.court.proj.notice.NoticeVO;

@Mapper
public interface MainMapper {

	ArrayList<AnnounceVO> getAnnList();
	ArrayList <FaqVO> getFaqList();
	ArrayList<NoticeVO> getNoticeList();
}
