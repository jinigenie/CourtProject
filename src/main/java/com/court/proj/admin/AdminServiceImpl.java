package com.court.proj.admin;

import java.util.List;

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

	@Override
	public int checkId(String admin_id) {
		return adminMapper.checkId(admin_id);
	}

	@Override
	public int registAdmin(AdminVO vo) {
		return adminMapper.registAdmin(vo);
	}

	@Override
	public List<AdminVO> getList() {
		return adminMapper.getList();
	}

}
