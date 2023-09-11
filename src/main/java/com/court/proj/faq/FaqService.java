package com.court.proj.faq;

import java.util.ArrayList;


public interface FaqService {

	ArrayList <FaqVO> getList(FaqCriteria cri);
	
	
}
