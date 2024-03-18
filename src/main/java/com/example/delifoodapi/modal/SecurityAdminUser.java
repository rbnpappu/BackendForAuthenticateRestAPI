package com.example.delifoodapi.modal;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.delifoodapi.SignUpEntity.AdminUser;

public class SecurityAdminUser implements UserDetails {
	
	private AdminUser user;
	

	public SecurityAdminUser(AdminUser user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getRestrotantOwnerPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getRestrotantOwnerName();
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		   return Arrays.stream(user
	                .getRoles()
	                .split(","))
	                .map(SimpleGrantedAuthority::new)
	                .toList();
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
