package com.court.proj.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CourtUserDetails implements UserDetails{

	//@Autowired
	private UserVO userVO;
	
	
	public CourtUserDetails(UserVO userVO) {
		this.userVO = userVO;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		List<GrantedAuthority> list = new ArrayList<>();
//		list.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				return userVO.getUser_role();
//			}
//		});
//		
//		return list;
//	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority("ROLE_"+userVO.getUser_role()));
	    
	    return authorities;
	}

	public String getUser_role() {
		return userVO.getUser_role();
	}
	
	public Integer getUser_proper_num() {
		return userVO.getUser_proper_num();
	}
	
	public String getUser_ar() {
		return userVO.getUser_ar();
	}
	public String getUser_ar_detail() {
		return userVO.getUser_ar_detail();
	}
	public String getUser_ar_zonecode() {
		return userVO.getUser_ar_zonecode();
	}
	public String getUser_bank() {
		return userVO.getUser_bank();
	}
	public String getUser_bank_account() {
		return userVO.getUser_bank_account();
	}
	public String getUser_bank_holder() {
		return userVO.getUser_bank_holder();
	}
	public String getUser_delete_yn() {
		return userVO.getUser_delete_yn();
	}
	public String getUser_edctn_final() {
		return userVO.getUser_edctn_final();
	}
	public String getUser_email_b() {
		return userVO.getUser_email_b();
	}
	public String getUser_email_f() {
		return userVO.getUser_email_f();
	}
	public String getUser_id() {
		return userVO.getUser_id();
	}
	public String getUser_job() {
		return userVO.getUser_job();
	}
	public String getUser_joindate() {
		return userVO.getUser_joindate();
	}
	
	public String getUser_rrn_b() {
		return userVO.getUser_rrn_b();
	}
	public String getUser_rrn_f() {
		return userVO.getUser_rrn_f();
	}
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userVO.getUser_pw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userVO.getUser_name();
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
		 // Y와 일치하면false (탈퇴한 사용자)
		// Y와 불일치하면 true (탈퇴하지 않은 사용자)
		return !"Y".equalsIgnoreCase(userVO.getUser_delete_yn());
	}

}
