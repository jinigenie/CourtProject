package com.court.proj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.court.proj.user.UserMapper;
import com.court.proj.user.UserVO;

@SpringBootTest
public class TestUpdate {
	
	
	@Autowired
	UserMapper userMapper;
	
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	//더미데이터 넣고 비밀번호 암호화된걸로 수정
	@Test
	public void update() {
		
		String pw = "123123123";
		String newpw = bCryptPasswordEncoder.encode(pw);
		UserVO vo = UserVO.builder().user_pw(newpw)
										  .user_proper_num(1).build();
		userMapper.update(vo);
		System.out.println(newpw);
		//$2a$10$9Fg6C87K9xlNTTUO2KcrD.P.jdMv4CB0JbbH3MAupuS3lThQ9uWiS
	}
	
	
}
