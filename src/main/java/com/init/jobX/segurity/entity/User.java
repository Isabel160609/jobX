package com.init.jobX.segurity.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
	@Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private String id;

   // private String name;
 
    @Column(unique = true)
    private String username;
 
    private String email;
    
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public User() {
    }

    public User (String userName, String email, String password) {
       // this.name = name;
        this.username = userName;
        this.email = email;
        this.password = password;
    }
    
    public User (String id,String userName, String email, String password,Set<Rol> roles) {
        this.id=id;
    	//this.name = name;
        this.username = userName;
        this.email = email;
        this.password = password;
        this.roles=roles;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String UserName) {
    	
        this.username = UserName;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
