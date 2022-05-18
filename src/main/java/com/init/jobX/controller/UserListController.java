package com.init.jobX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.jobX.segurity.entity.User;
import com.init.jobX.service.UserListService;

@RestController
@RequestMapping("/")
public class UserListController {

	@Autowired
	UserListService userListService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers() {
		try {
			List<User> users = userListService.listUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
