package com.court.proj.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
	public AdminVO login(String admin_id);
}
