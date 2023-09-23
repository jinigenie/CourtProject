package com.court.proj.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.proj.fcltt.FclttCriteria;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
@Autowired
private NoticeMapper noticeMapper;

// 목록 / total
@Override
public ArrayList<NoticeVO> getList(FclttCriteria cri) {
	return noticeMapper.getList(cri);
}
@Override
public int getTotal(FclttCriteria cri) {
	return noticeMapper.getTotal(cri);
}
@Override
public int noticeReg(NoticeVO vo) {
	return noticeMapper.noticeReg(vo);
}
	


	

}
