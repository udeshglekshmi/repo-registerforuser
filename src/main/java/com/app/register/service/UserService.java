package com.app.register.service;

import com.app.register.model.UserModel;
import com.app.register.repository.UserRepository; 
import com.app.register.dto.UserDto; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;

	public UserModel registerUser(UserDto userDto){
		UserModel user = new UserModel();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername()); 
		return userRepository.save(user);
	}

	/*public List<UserModel> getAllUsers(){
		return UserRepository.findAll();
	}

	public Optional<UserModel> getUserById(Long id){
		return UserRepository.findById(id);
	}

	public void deleteUser(Long id){
		UserRepository.deleteById(id);
	}*/ 
}