package com.court.proj.user;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

	public UserVO getUser(int user_proper_num);
	public int deleteUpdate(UserVO vo);
	public int modifyUpdate(UserVO vo); //
	public ArrayList<ActiveVO> getHistory(int user_proper_num);

}
