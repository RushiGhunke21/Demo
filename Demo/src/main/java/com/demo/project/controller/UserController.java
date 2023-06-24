package com.demo.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.model.User;
import com.demo.project.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		
		List<User> userList = new ArrayList<>();
				
		for(User user : users) {
			User user2 = new User();
			user2.setId(user.getId());
			user2.setFirstName(user.getFirstName());
			user2.setDob(user.getDob());
			user2.setUserName(user.getUserName());
			user2.setEmail(user.getEmail());
			user2.setLastName(user.getLastName());
			userList.add(user2);
		}
		
		return userList;
		
	}
	
}
