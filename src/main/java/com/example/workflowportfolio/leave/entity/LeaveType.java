package com.example.workflowportfolio.leave.entity;

import lombok.Data;

@Data
public class LeaveType {
	private Long id;				//申請タイプID
	private String name;			//申請名称
	private String description;	//詳細
	private Long flowId;			//承認フローID
}
