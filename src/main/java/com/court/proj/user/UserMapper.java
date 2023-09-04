package com.court.proj.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public int checkId(String user_id);
	public int userJoin(UserVO vo);
}
