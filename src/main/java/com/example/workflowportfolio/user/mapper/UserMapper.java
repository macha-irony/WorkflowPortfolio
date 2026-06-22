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
	/*
	 * 現在は役職ごとにユーザーが1名の前提。
	 * 将来的に同一役職のユーザーが複数存在する場合は
	 * List<User>への変更を検討する。
	 */
	User findByPositionId(Long positionId);
}
