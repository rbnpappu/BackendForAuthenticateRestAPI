package com.example.delifoodapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.delifoodapi.Repository.RoleDao;
import com.example.delifoodapi.SignUpEntity.RegisterUserRole;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	public RegisterUserRole createNewRole(RegisterUserRole role) {
		return roleDao.save(role);
		
	}

}
