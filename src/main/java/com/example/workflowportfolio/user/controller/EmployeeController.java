package com.example.workflowportfolio.user.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workflowportfolio.user.entity.User;
import com.example.workflowportfolio.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final UserService userService;
	
	@GetMapping
	public String top(HttpSession session) {
		User loginUser = userService.findById(1L);

	    session.setAttribute("loginUser", loginUser);
		return "employee/top";
		
	}
}
