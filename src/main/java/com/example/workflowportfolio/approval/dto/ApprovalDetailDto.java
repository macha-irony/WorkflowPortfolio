package com.example.workflowportfolio.approval.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApprovalDetailDto {
	private Long leaveId;

    private String applicantName;

    private String leaveTypeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String leaveStatus;

    private LocalDateTime appliedAt;
}
