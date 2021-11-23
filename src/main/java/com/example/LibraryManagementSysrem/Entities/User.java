package com.example.LibraryManagementSysrem.Entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
@Entity
@Table(name="users",uniqueConstraints =@UniqueConstraint(name = "username",columnNames={"name","email"}))
public class User {
    public enum type{ADMIN,USER};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private type role;

    public type getRole() {
        return role;
    }

    public void setRole(type role) {
        this.role = role;
    }

    private boolean enabled;

    public User() {
    }

    public User(Long id, String name, String email, String passKey, boolean enabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = passKey;
        this.enabled = enabled;
    }

    public User(String name, String email, String passKey, boolean enabled) {
        this.name = name;
        this.email = email;
        this.password = passKey;
        this.enabled = enabled;
    }

    public User(String name, String email, String passKey) {
        this.name = name;
        this.email = email;
        this.password = passKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
