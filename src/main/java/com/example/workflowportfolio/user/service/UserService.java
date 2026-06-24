package com.example.workflowportfolio.user.service;

import org.springframework.stereotype.Service;

import com.example.workflowportfolio.user.entity.User;
import com.example.workflowportfolio.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;
	
	public User findById(Long id) {
		return userMapper.findById(id);
	}
}
