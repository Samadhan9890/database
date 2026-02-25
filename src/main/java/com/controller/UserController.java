package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Userdto;
import com.entity.User;
import com.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	UserService usr;
	@PostMapping("/register")
	public String register(@RequestBody User u) {
		return usr.register(u);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Userdto udto){
		User exstinguser=usr.login(udto);
		if(exstinguser!=null) {
			return ResponseEntity.ok(exstinguser);
		}
		else {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Invalid username or password");
		}
	}

}
