package com.court.proj.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public AdminVO login(String admin_id) {
		// TODO Auto-generated method stub
		return adminMapper.login(admin_id);
	}

}
