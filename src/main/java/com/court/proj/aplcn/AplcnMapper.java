package com.court.proj.aplcn;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.court.proj.aplcn.util.Criteria;

@Mapper
public interface AplcnMapper {

	// public int aplcn_evaluate();
	public ArrayList<ListVO> getList(@Param("user_proper_num") int user_proper_num, @Param("cri") Criteria cri);
	public int getTotal(@Param("user_proper_num") int user_proper_num, @Param("cri") Criteria cri); // 전체게시글수
	
	public ArrayList<ListVO> getDetails(@Param("aplcn_dtls_proper_num") int aplcn_dtls_proper_num);
	public ListVO getDetail(@Param("aplcn_dtls_proper_num") int aplcn_dtls_proper_num);
	
	public int getEvaluate(ListVO vo);

}
