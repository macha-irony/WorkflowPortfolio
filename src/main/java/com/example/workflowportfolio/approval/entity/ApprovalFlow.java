package com.example.workflowportfolio.approval.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApprovalFlow {
	private Long id;
	private String name;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
