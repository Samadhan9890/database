package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Userdto;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uresp;
	public String register(User u) {
		User exstinguser=uresp.findByUsername(u.getUsername());
		if(exstinguser==null) {
			uresp.save(u);
			return "Registration Sucessfully";
		}
		else {
			return "Username already exists";
		}
		
	}
	public User login(Userdto utd) {
		User exstinguser=uresp.findByUsername(utd.getUsername());
		if(exstinguser==null) {
			return null;
		}
		else {
			if(exstinguser.getPassword().equals(utd.getPassword())) {
				return exstinguser;
			}
			else {
				return null;
			}
		}
		
	}

}
