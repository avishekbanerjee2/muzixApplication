package com.stackroute.accountmanager.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.services.SecurityTokenGenerator;
import com.stackroute.accountmanager.services.UserService;

@RestController
@EnableWebMvc
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityTokenGenerator tokenGenerator;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("{\"message\":\"" + e.getMessage() + "\"}", HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		try {
			String userId = user.getUserId();
			String password = user.getPassword();

			if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
				throw new Exception("UserId or Password cannot be empty");

			}
			User loginUser = userService.findByUserIdAndPassword(userId, password);
			if (loginUser == null) {
				throw new Exception("User with given Id or Password does not exists");
			}

			if (!password.equals(loginUser.getPassword())) {
				throw new Exception("Invalid credentials");
			}
			Map<String, String> tokenMap = tokenGenerator.generateToken(user);
			return new ResponseEntity<Map<String, String>>(tokenMap, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("{\"message\":\"" + e.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}

}
