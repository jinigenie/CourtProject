package com.court.proj.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CourtAdminDetails implements UserDetails{

	//@Autowired
	private AdminVO adminVO;
	
	
	public CourtAdminDetails(AdminVO adminVO) {
		this.adminVO = adminVO;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ROLE_"+adminVO.getAdmin_auth()));
		
		
		return list;
	}

	public String getAdmin_auth() {
		return adminVO.getAdmin_auth();
	}
	
	
	public Integer getAdmin_proper_num() {
		return adminVO.getAdmin_proper_num();
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return adminVO.getAdmin_pw();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return adminVO.getAdmin_id();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	


	
}
