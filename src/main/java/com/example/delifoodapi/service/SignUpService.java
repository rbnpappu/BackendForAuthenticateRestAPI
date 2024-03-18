package com.example.delifoodapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.delifoodapi.Repository.AdminRepository;
import com.example.delifoodapi.Repository.RegisterRepository;
import com.example.delifoodapi.SignUpEntity.AdminUser;
import com.example.delifoodapi.SignUpEntity.RegisterUser;

@Service
public class SignUpService {
    private final RegisterRepository service;
    private final AdminRepository adminservice;

    @Autowired
    public SignUpService(RegisterRepository service , AdminRepository adminservice) {
        this.service = service;
        this.adminservice = adminservice;
    }

    public RegisterUser save(RegisterUser user) {
        return service.save(user);
    }
    
    public AdminUser save(AdminUser admin){
    	return adminservice.save(admin);
    }

    public Iterable<RegisterUser> get() {
        return service.findAll();
    }
    
    public Iterable<RegisterUser> getAdminUser(){
    	return service.findAll();
    }
}
