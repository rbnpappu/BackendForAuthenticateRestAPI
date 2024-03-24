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

import com.example.delifoodapi.SignUpEntity.RegisterUser;

import com.example.delifoodapi.service.SignUpService;

import jakarta.validation.Valid;

@RestController
public class SignUPController {
	
	private final SignUpService userService;

	
	public SignUPController(SignUpService userService ) {
		this.userService = userService;

	}
    @PostMapping("/RegisterUser")
    public ResponseEntity<RegisterUser> signUpUser(@Valid @RequestBody RegisterUser user) {
         userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userService.get())
                .toUri();
        return ResponseEntity.created(location).build();
    }

	
	@GetMapping("/Register")
	public Iterable<RegisterUser> GetSignUPUser(){
		return userService.get();
	}
	
	  @GetMapping("/admin")
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
	    public String adminEndpoint() {
	        return "This endpoint is accessible only by users with ROLE_ADMIN role";
	    }

	  @GetMapping("/user")
	  @PreAuthorize("hasRole('ROLE_user')")
	  public String userEndpoint() {
	      return "This endpoint is accessible only by users with ROLE_USER role";
	  }
	  
	
}
