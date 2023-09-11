package com.court.proj.faq;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FaqMapper {
	
	ArrayList <FaqVO> getList(@Param("cri") FaqCriteria cri);

}
