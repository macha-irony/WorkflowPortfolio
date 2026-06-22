package com.example.workflowportfolio.approval.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApprovalWaitingListDto {
	private Long leaveId;

    private String applicantName;

    private String leaveTypeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime createdAt;
}
