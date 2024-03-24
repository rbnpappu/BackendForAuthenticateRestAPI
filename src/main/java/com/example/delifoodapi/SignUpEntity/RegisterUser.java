package com.example.delifoodapi.SignUpEntity;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class RegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "retype_password")
    private String retypePassword; // Not stored in the database

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RegisterUserRole> roles;

    public RegisterUser() {
        // Default constructor body (if needed)
    }

    
    
	public RegisterUser(Long id, String userName, String password, String retypePassword, Set<RegisterUserRole> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.retypePassword = retypePassword;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<RegisterUserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<RegisterUserRole> roles) {
		this.roles = roles;
	}

    
    
}
