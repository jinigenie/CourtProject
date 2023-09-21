package com.court.proj.aplcn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.court.proj.aplcn.util.Criteria;

@Service("aplcnService")
public class AplcnServiceImpl implements AplcnService {

	@Autowired
	private AplcnMapper aplcnMapper;
	
	//신청자 리스트
	@Override
	public ArrayList<ListVO> getList(Criteria cri) {
		return aplcnMapper.getList(cri);
	}

	//신청자 리스트 (페이징)
	@Override
	public int getTotal(Criteria cri) {
		return aplcnMapper.getTotal(cri);
	}
	
	//신청자 상세정보 (복수값)
	@Override
	public ArrayList<ListVO> getDetails(int aplcn_dtls_proper_num) {
		return aplcnMapper.getDetails(aplcn_dtls_proper_num);
	}

	//신청자 상세정보 (단수값)
	@Override
	public ListVO getDetail(int aplcn_dtls_proper_num) {
		return aplcnMapper.getDetail(aplcn_dtls_proper_num);
	}
	
	//신청자 상태변환1 (서류반려)
	@Override
	public int aplcnReject(ListVO vo) {
		return aplcnMapper.aplcnReject(vo);
	}
	
	//신청자 상태변환2 (평가완료)
	@Override
	public int aplcnCompleted(ListVO vo) {
		return aplcnMapper.aplcnCompleted(vo);
	}
		
	//신청자 평가 (수정중)
	@Override
	public int aplcnEvaluate(ListVO vo) {
		int result = aplcnMapper.aplcnEvaluate(vo);
		return result;
	}

	//파일 다운로드
	@Override
	public ListVO aplcnFiles(int aplcn_dtls_proper_num) {
		return aplcnMapper.aplcnFiles(aplcn_dtls_proper_num);
	}

	
}
