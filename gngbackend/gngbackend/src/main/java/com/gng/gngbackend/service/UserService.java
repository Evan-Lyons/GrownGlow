package com.gng.gngbackend.service;

import com.gng.gngbackend.LoginMessage;
import com.gng.gngbackend.dto.LoginDTO;
import com.gng.gngbackend.dto.UserDTO;
import com.gng.gngbackend.model.User;

import java.util.List;

public interface UserService {
	
	String saveUser(UserDTO userdto);
	
	LoginMessage loginUser(LoginDTO logindto);

	UserDTO getUserById(Long id);

	public List<User> getAllUsers();
}
