package com.example.workflowportfolio.approval.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class History {
	private Long id;
	private Long leaveId;
	private Long approvalId;
	private Long operatorId;
	private Integer stepNo;
	private String action;
	private String comment;
	private LocalDateTime createdAt;
}
