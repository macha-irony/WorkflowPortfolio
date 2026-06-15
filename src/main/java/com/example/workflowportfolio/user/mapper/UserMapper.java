package com.example.workflowportfolio.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.workflowportfolio.user.entity.User;

@Mapper
public interface UserMapper {
	User findById(Long id);
	User findByLoginId(String loginId);
	List<User> findAll();
	int insert(User user);
}
