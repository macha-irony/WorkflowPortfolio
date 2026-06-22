package com.example.workflowportfolio.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.workflowportfolio.approval.entity.ApprovalFlowStep;

@Mapper
public interface ApprovalFlowStepMapper {
	List<ApprovalFlowStep> findByFlowId(Long flowId);
}
