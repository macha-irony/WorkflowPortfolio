package com.example.workflowportfolio.leave.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Leave {
	private Long id;
	private Long applicantId;
	private Long leaveTypeId;
	private Long approvalFlowId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
