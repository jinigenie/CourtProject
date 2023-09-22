package com.court.proj.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
	//로그인
	public AdminVO login(String admin_id);
	//아이디 중복확인
	public int checkId(String admin_id);
	//관리자 등록
	public int registAdmin(AdminVO vo);
	//관리자 목록
	public List<AdminVO> getList();
}
