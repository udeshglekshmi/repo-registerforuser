package com.app.register.dto; 

import jakarta.validation.constraints.Email;   
import jakarta.validation.constraints.NotBlank; 

public class UserDto {
    
    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    /*@Size(min = 6, message = "Password must be at least 6 characters")
    private String password; */ 

    /* Constructor
    public UserDto() {
    }

    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    } */ 

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
