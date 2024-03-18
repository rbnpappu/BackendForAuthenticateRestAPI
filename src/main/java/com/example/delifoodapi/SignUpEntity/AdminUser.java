package com.example.delifoodapi.SignUpEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="admin")
@Data
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="restrotantOwnerName")
    private String restrotantOwnerName;

    @Column(name="restrotantOwnerPassword")
    private String RestrotantOwnerPassword;

    @Column(name="restrotantOwnerRetypePassword")
    private String RestrotantOwnerRetypePassword;

    @Column(name="roles")
    private String roles;

    // No-argument constructor is required for JPA
    public AdminUser() {
    }

    // Constructor with all fields
    public AdminUser(Long id, String restrotantOwnerName, String RestrotantOwnerPassword,
                     String RestrotantOwnerRetypePassword, String roles) {
        this.id = id;
        this.restrotantOwnerName = restrotantOwnerName;
        this.RestrotantOwnerPassword = RestrotantOwnerPassword;
        this.RestrotantOwnerRetypePassword = RestrotantOwnerRetypePassword;
        this.roles = roles;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestrotantOwnerName() {
        return restrotantOwnerName;
    }

    public void setRestrotantOwnerName(String restrotantOwnerName) {
        this.restrotantOwnerName = restrotantOwnerName;
    }

    public String getRestrotantOwnerPassword() {
        return RestrotantOwnerPassword;
    }

    public void setRestrotantOwnerPassword(String RestrotantOwnerPassword) {
        this.RestrotantOwnerPassword = RestrotantOwnerPassword;
    }

    public String getRestrotantOwnerRetypePassword() {
        return RestrotantOwnerRetypePassword;
    }

    public void setRestrotantOwnerRetypePassword(String RestrotantOwnerRetypePassword) {
        this.RestrotantOwnerRetypePassword = RestrotantOwnerRetypePassword;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    // toString() method
    @Override
    public String toString() {
        return "AdminUser [id=" + id + ", restrotantOwnerName=" + restrotantOwnerName +
                ", RestrotantOwnerPassword=" + RestrotantOwnerPassword +
                ", RestrotantOwnerRetypePassword=" + RestrotantOwnerRetypePassword +
                ", roles=" + roles + "]";
    }
}
