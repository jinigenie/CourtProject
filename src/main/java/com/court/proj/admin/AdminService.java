package com.court.proj.admin;

public interface AdminService {
	public AdminVO login(String admin_id);
	public int checkId(String admin_id);
	public int registAdmin(AdminVO vo);
}
