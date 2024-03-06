package com.example.delifoodapi.SignUp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class RegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Size(min = 5)
    @Column(name = "UserName")
	private String UserName;
    @Column(name = "Password")
	private String password;
    @Column(name = "retyprPassword")
	private String retypePassword;

}
