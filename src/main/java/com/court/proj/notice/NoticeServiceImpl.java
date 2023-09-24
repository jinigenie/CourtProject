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

// 공지 등록
@Override
public int noticeReg(NoticeVO vo) {
	return noticeMapper.noticeReg(vo);
}

//공지 상세보기
@Override
public NoticeVO getDetail(String notice_proper_num) {
	return noticeMapper.getDetail(notice_proper_num);
}
//공지 수정
@Override
public int noticeModify(NoticeVO vo) {
	return noticeMapper.noticeModify(vo);
}
//공지 삭제
@Override
public int noticeDel(String notice_proper_num) {
	return noticeMapper.noticeDel(notice_proper_num);
}
	


	

}
