package com.example.delifoodapi.SignUp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class SignUpService {

    private final RegisterRepository service;

    @Autowired
    public SignUpService(RegisterRepository service) {
        this.service = service;
    }

    public void save(RegisterUser user) {
        service.save(user);
    }

	public List<RegisterUser> get() {
	 List<RegisterUser> user = service.findAll();
	 return user;
	}
}