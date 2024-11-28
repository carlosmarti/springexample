package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRespository;

@RestController
@CrossOrigin(origins="https://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRespository userRepository;
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		
		return (List<Users>) userRepository.findAll();
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody Users user) {
		
	}
}
