package com.example.workflowportfolio.approval.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.workflowportfolio.approval.dto.ApprovalDetailDto;
import com.example.workflowportfolio.approval.dto.ApprovalWaitingListDto;
import com.example.workflowportfolio.approval.entity.Approval;

@Mapper
public interface ApprovalMapper {
	int insert(Approval approval);
	List<ApprovalWaitingListDto> findPendingApproval(@Param("approverId") Long approverId);
	ApprovalDetailDto findDetail(Long leaveId, Long approverId);
}
