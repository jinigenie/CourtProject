package com.court.proj.aplcn;

import java.util.ArrayList;

import com.court.proj.aplcn.util.Criteria;

public interface AplcnService {
	
	//public int aplcn_evaluate();
	public ArrayList<ListVO> getList(int user_proper_num, Criteria cri);
	public int getTotal(int user_proper_num, Criteria cri); //전체 게시글 수
	public ArrayList<ListVO> getDetails(int aplcn_dtls_proper_num); //상세
	public ListVO getDetail(int aplcn_dtls_proper_num); 
	
	public int getEvaluate(ListVO vo);
}
