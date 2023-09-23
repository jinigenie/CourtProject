package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.court.proj.announce.AnnounceVO;
import com.court.proj.fcltt.FclttCriteria;

@Service("faqService")
public class FaqServiceImpl implements FaqService{
	
	@Autowired
	private FaqMapper faqMapper;

	// faq 리스트 . 토탈 불러오기 
	@Override
	public ArrayList<FaqVO> getList(FclttCriteria cri) {
		return faqMapper.getList(cri);
	}
	@Override
	public int getTotal(FclttCriteria cri) {
		return faqMapper.getTotal(cri);
	}
	
	// 글 수정하기 진입시 해당글 조회
	@Override
	public FaqVO getDetail(String faq_proper_num) {
		return faqMapper.getDetail(faq_proper_num);
	}
	
	// 글 수정하기
	@Override
	public int faqModify(FaqVO vo) {
		return faqMapper.faqModify(vo);
	}
	// 글 삭제하기
	@Override
	public int faqDel(String faq_proper_num) {
		return faqMapper.faqDel(faq_proper_num);
	}
	
	//faq 글 등록하기
	@Override
	public int faqRag(FaqVO vo) {
		return faqMapper.faqRag(vo);
	}
	@Override
	public String getinfo(String admin_id) {
		return faqMapper.getinfo(admin_id);
	}
	



}
