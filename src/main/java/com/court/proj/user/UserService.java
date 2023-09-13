package com.court.proj.user;

public interface UserService {
	public int checkId(String user_id);
	public int joinUser(UserVO vo);
	public String searchId(String phone);
	public int updatePw(String phone, String newPw);
}
