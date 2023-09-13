package com.court.proj.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
	public int checkId(String user_id);
	public int userJoin(UserVO vo);
	public String searchId(String phone);
	
	public UserVO login(String user_id);
	public int update(UserVO vo);
	
	public int updatePw(@Param("phone") String phone, @Param("newPw") String newPw);
}
