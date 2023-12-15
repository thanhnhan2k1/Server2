package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/test")
public class TestConroller {
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/getId")
	public User allAccess() {
		return userRepo.findByEmail("ha@gmail.com");
	}
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")// để kiểm tra quyền được truy cập
	public String userAccess() {
		return "User Content";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Content";
	}
}
