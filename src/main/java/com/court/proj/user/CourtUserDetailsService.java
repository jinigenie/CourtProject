package com.court.proj.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.court.proj.admin.AdminMapper;
import com.court.proj.admin.AdminVO;
import com.court.proj.admin.CourtAdminDetails;

@Service
public class CourtUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		System.out.println("넘어온 아이디 : "+username);
		
		if(username.startsWith("admin")) {
			System.out.println("admin으로 시작함");
			AdminVO vo = adminMapper.login(username);
			
			if(vo != null) {
				return new CourtAdminDetails(vo);
			}
		} else {
			UserVO vo = userMapper.login(username);
			if(vo != null) {
				return new CourtUserDetails(vo);
			}
			
		}
		
		
		return null;
	}

	
	
}
