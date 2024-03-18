package com.example.delifoodapi;

import java.net.URI;
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.delifoodapi.SignUpEntity.AdminUser;
import com.example.delifoodapi.SignUpEntity.RegisterUser;
import com.example.delifoodapi.service.AdminSigninService;
import com.example.delifoodapi.service.SignUpService;

import jakarta.validation.Valid;

@RestController
public class SignUPController {
	
	private final SignUpService userService;
	private final AdminSigninService adminService;
	
	public SignUPController(SignUpService userService, AdminSigninService adminService) {
		this.userService = userService;
		this.adminService = adminService;
	}
	
	@PostMapping("/RegisterUser")
	public ResponseEntity<RegisterUser> SignUPUser(@Valid @RequestBody RegisterUser user){
		RegisterUser savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/RegisterAdminUser")
	public ResponseEntity<AdminUser> SignUPAdminUser(@Valid @RequestBody AdminUser user){
		AdminUser savedUser = adminService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/Register")
	public Iterable<RegisterUser> GetSignUPUser(){
		return userService.get();
	}

}
