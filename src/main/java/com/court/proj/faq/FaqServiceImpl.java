package com.court.proj.faq;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("faqService")
public class FaqServiceImpl implements FaqService{
	
	@Autowired
	private FaqMapper faqMapper;

	@Override
	public ArrayList<FaqVO> getList(FaqCriteria cri) {
		return faqMapper.getList(cri);
	}

}
