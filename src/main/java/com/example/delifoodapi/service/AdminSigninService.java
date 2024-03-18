package com.example.delifoodapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.delifoodapi.Repository.AdminRepository;
import com.example.delifoodapi.SignUpEntity.AdminUser;

@Service
public class AdminSigninService {
	private final AdminRepository userrepo;

	@Autowired
	public AdminSigninService(AdminRepository userrepo) {
		this.userrepo = userrepo;
	}
	
	public AdminUser save(AdminUser admin) {
		return userrepo.save(admin);
	}

}
