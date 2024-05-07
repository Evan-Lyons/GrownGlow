package com.gng.gngbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gng.gngbackend.LoginMessage;
import com.gng.gngbackend.dto.LoginDTO;
import com.gng.gngbackend.dto.UserDTO;
import com.gng.gngbackend.model.User;
import com.gng.gngbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String saveUser(UserDTO userDTO) {
		// Check if the user already exists
		User existingUser = userRepo.findByEmail(userDTO.getEmail());
		if (existingUser != null) {
			// User already exists, return null or throw an exception
			return null;
		}

		// Create a new user entity
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		// Save the user to the database
		userRepo.save(user);

		// Return the email of the saved user
		return user.getEmail();
	}

	@Override
	public LoginMessage loginUser(LoginDTO loginDTO) {

		//String msg = "";
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if (user1 != null) {
			String password = loginDTO.getPassword();
			Boolean isPwdRight = password.equals(loginDTO.getPassword());
			if (isPwdRight) {
				Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), password);
				if (user.isPresent()) {
					return new LoginMessage("Login Success", true);
				} else {
					return new LoginMessage("Login Failed", false);
				}
			} else {
				return new LoginMessage("password does not match", false);
			}
		} else {
			return new LoginMessage("Email does not exist", false);
		}


	}
	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepo.findById(id).orElse(null);
		if (user != null) {
			return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
		} else {
			return null;
		}

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}