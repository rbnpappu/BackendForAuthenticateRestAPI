package com.example.delifoodapi.SignUpEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class RegisterUser  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="retypePassword")
    private String retypePassword;
    
    @Column(name="roles")
    private String roles;

    public RegisterUser() {
        // Default constructor required by JPA
    }

    public RegisterUser(String userName, String password, String retypePassword, String roles) {
        this.userName = userName;
        this.password = password;
        this.retypePassword = retypePassword;
        this.roles = roles;
    }

    // Getter and setter methods for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

	public RegisterUser(Long id, String userName, String password, String retypePassword, String roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.retypePassword = retypePassword;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
