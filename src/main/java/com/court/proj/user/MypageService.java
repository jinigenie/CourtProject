package com.court.proj.user;


public interface MypageService {
	
	public UserVO getUser(int user_proper_num);
	public int deleteUpdate(UserVO vo);
	public int modifyUpdate(UserVO vo);

}
