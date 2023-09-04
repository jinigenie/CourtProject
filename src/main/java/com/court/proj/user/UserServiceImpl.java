package com.court.proj.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public int checkId(String user_id) {
		return userMapper.checkId(user_id);
	}

	@Override
	public int joinUser(UserVO vo) {
		return userMapper.userJoin(vo);
	}

}
