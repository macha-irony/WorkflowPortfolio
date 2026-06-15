package com.example.workflowportfolio.leave.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LeaveApplyForm {
	private Long leaveTypeId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;
}
