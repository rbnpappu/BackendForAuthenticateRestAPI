package com.example.delifoodapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.delifoodapi.SignUpEntity.RegisterUserRole;
import com.example.delifoodapi.service.RoleService;

@RestController
public class RoleConroller {
	@Autowired
	private RoleService roleService; 
	
    @PostMapping({"/createNewRole"})
    public RegisterUserRole createNewRole(@RequestBody RegisterUserRole role) {
        return roleService.createNewRole(role);
    }

}
