package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Override
	public FaqVO getDetail(String faq_proper_num) {
		return faqMapper.getDetail(faq_proper_num);
	}
	@Override
	public int faqDel(String faq_proper_num) {
		return faqMapper.faqDel(faq_proper_num);
	}


}
