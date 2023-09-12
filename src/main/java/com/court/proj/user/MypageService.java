package com.court.proj.user;

import java.util.ArrayList;

public interface MypageService {
	
	public UserVO getUser(int user_proper_num);
	public int deleteUpdate(UserVO vo);
	public int modifyUpdate(UserVO vo);
	public ArrayList<ActiveVO> getHistory(int user_proper_num);

}
