package com.example.workflowportfolio.leave.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class LeaveDetailDto {
	private Long id;

    private String leaveTypeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
