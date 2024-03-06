package com.example.delifoodapi.SignUp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUPController {
	@Autowired
	SignUpService userService;
	
	@PutMapping("/Register")
	public void SignUPUser(RegisterUser user){
		userService.save(user);
	}
	
	@GetMapping("/Register")
	public List<RegisterUser> GetSignUPUser(){
		List<RegisterUser> user= userService.get();
		return user;
	}
	
}
