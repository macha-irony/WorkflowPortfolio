package com.example.workflowportfolio.approval.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApprovalFlowStep {
	private Long id;
	private Long flowId;				
	private Integer stepNo;			
	private Long approverPositionId;	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
