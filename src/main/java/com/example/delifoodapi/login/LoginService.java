package com.example.delifoodapi.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.delifoodapi.SignUp.RegisterRepository;

@Component
public class LoginService {
	private final RegisterRepository service;
	
    @Autowired
    public LoginService(RegisterRepository service) {
        this.service = service;
    }


}
