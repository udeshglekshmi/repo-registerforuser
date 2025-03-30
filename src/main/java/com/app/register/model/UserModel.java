package com.app.register.model;

import jakarta.persistence.*; //JPA = Jakarta Persistence Application

@Entity 
@Table(name = "usertable")
public class UserModel{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(nullable=false, unique=true)
private String email;
@Column(nullable=false, unique=true)
private String username;

public void setId(long id){
	this.id = id;
}
public long getId(){
	return id;
}

public void setEmail(String email){
	this.email = email;
}
public String getEmail(){
	return email;
}

public void setUsername(String username){
	this.username = username;
}
public String getUsername(){
	return username;
}
}