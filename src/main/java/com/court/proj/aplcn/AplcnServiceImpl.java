package com.court.proj.aplcn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.court.proj.aplcn.util.Criteria;

@Service("aplcnService")
public class AplcnServiceImpl implements AplcnService {

	@Autowired
	private AplcnMapper aplcnMapper;
	
//	@Override
//	public int aplcn_evaluate() {
//		return aplcnMapper.aplcn_evaluate();
//	}

	@Override
	public ArrayList<ListVO> getList(int user_proper_num, Criteria cri) {
		return aplcnMapper.getList(user_proper_num, cri);
	}

	@Override
	public int getTotal(int user_proper_num, Criteria cri) {
		return aplcnMapper.getTotal(user_proper_num, cri);
	}
	
	@Override
	public ArrayList<ListVO> getDetails(int aplcn_dtls_proper_num) {
		return aplcnMapper.getDetails(aplcn_dtls_proper_num);
	}

	@Override
	public ListVO getDetail(int aplcn_dtls_proper_num) {
		return aplcnMapper.getDetail(aplcn_dtls_proper_num);
		
	}
	@Override
	public int getEvaluate(ListVO vo) {
		
		int result = aplcnMapper.getEvaluate(vo);
		
		return result;
	}




	
}
