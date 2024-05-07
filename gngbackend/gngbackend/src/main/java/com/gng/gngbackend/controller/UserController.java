package com.gng.gngbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gng.gngbackend.LoginMessage;
import com.gng.gngbackend.dto.LoginDTO;
import com.gng.gngbackend.dto.UserDTO;
import com.gng.gngbackend.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/save")
	public ResponseEntity<String> save(@RequestBody UserDTO userDTO) {
		String id = userService.saveUser(userDTO);
		if (id != null) {
			return ResponseEntity.ok().body("{\"New user added\", \"userId\", \"email\", \"password\", \"username\": \"" + id + "\"}");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"User registration failed\"}");
		}
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		UserDTO userDTO = userService.getUserById(id);
		if(userDTO != null) {
			return ResponseEntity.ok(userDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?>loginUser(@RequestBody LoginDTO loginDTO){

		LoginMessage loginMessage = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginMessage);

	}
	@GetMapping(path = "/getAll")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
}
