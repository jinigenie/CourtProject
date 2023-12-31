package com.court.proj.user;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface MypageService {
	
	public UserVO getUser(int user_proper_num);
	public int deleteUpdate(UserVO vo);
	public int modifyUpdate(UserVO vo);
	public ArrayList<ActiveVO> getHistory(@Param("user_proper_num") int user_proper_num,
										  @Param("cri") HistoryCriteria cri);
	public int historyTotal(@Param("user_proper_num") int user_proper_num,
						    @Param("cri") HistoryCriteria cri);
	public MypageStatusVO getStatus(int user_proper_num);
	public ArrayList<MypageStatusVO> getDocu(int aplcn_dtls_proper_num);
	public int regPause(PauseDataVO vo);
	public PauseDataVO getPause(int user_proper_num);
	public boolean pauseAccess(int user_proper_num);
	public int deleteAplicn(int aplcn_dtls_proper_num);
	
	
}
