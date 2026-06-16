package com.example.workflowportfolio.leave.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LeaveListDto {
	private Long id;
	
	//private Long applicantId;
    
	private String leaveTypeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private LocalDateTime createdAt;
}
