package com.court.proj.fcltt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fclttService")
public class FclttServiceImple implements FclttService {
	
	@Autowired
	private FclttMapper fclttMapper;
	
	//조력자 등재
	@Override
	public int fclttRegist(FclttVO vo) {
		return fclttMapper.fclttRegist(vo);
	}

	// 조력자명단조회
	@Override
	public ArrayList<FclttVO> getList(FclttCriteria cri) {
		return fclttMapper.getList(cri);
	}
	// 조력자명단조회 페이징
	@Override
	public int getTotal(FclttCriteria cri) {
		System.out.println("서비스에 들어온 값 확인 ! : " + cri.toString()+cri.getSearchAccept_act_yn());

		return fclttMapper.getTotal(cri);
	}

	
	// 중지신청 목록
	@Override
	public ArrayList<PauseVO> getPauseList(FclttCriteria cri) {
		return fclttMapper.getPauseList(cri);
	}

	//중지신청 total
	@Override
	public int getPauseTotal(FclttCriteria cri) {
		return fclttMapper.getPauseTotal(cri);
	}
	
	// 승인처리  활동중일경우(Y) -> 중지로 바꾸기(N)
	@Override
	public int setPauseY(FclttVO vo) {
		return fclttMapper.setPauseY(vo);
	}
	// 승인처리  활동중일경우(N) -> 중지로 바꾸기(Y)
	@Override
	public int setPauseN(FclttVO vo) {
		return fclttMapper.setPauseN(vo);
	}

	//------------------------------------------------------------------
	//명단에서 상세보기 ajax 1. 기본정보
	@Override
	public FclttVO getFclttContent1(String accept_proper_num) {
		return fclttMapper.getFclttContent1(accept_proper_num);
	}

	//명단에서 상세보기 ajax 2. 학력정보
	@Override
	public ArrayList<FclttVO> getFclttContent2(String user_proper_num) {
		return fclttMapper.getFclttContent2(user_proper_num);
	}

	//명단에서 상세보기 ajax 3. 재판이력
	@Override
	public ArrayList<FclttVO> getFclttContent3(String user_proper_num) {
		return fclttMapper.getFclttContent3(user_proper_num);
	}

	//명단에서 상세보기 ajax 4. 자격증 
	@Override
	public ArrayList<FclttVO> getFclttContent4(String user_proper_num) {
		return fclttMapper.getFclttContent4(user_proper_num);
	}

	//명단에서 상세보기 ajax 5. 경력
	@Override
	public ArrayList<FclttVO> getFclttContent5(String user_proper_num) {
		return fclttMapper.getFclttContent5(user_proper_num);
	}
	//------------------------------------------------------------------


}
