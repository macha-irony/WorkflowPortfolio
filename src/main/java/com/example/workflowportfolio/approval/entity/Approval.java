package com.example.workflowportfolio.approval.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Approval {
	private Long id;
	private Long leaveId;
	private Long approverId;
	private Integer stepNo;
	private String status;
	private String comment;
	private LocalDateTime approvalAt;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
