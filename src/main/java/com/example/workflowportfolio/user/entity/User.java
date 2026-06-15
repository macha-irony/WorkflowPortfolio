package com.example.workflowportfolio.user.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class User {
	private Long id;
	private String loginId;
	private String password;
	private String name;
	private Long roleId;
	private Long positionId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
