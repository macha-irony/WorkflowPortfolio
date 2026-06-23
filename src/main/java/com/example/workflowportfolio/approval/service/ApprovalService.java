package com.example.workflowportfolio.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workflowportfolio.approval.dto.ApprovalDetailDto;
import com.example.workflowportfolio.approval.dto.ApprovalWaitingListDto;
import com.example.workflowportfolio.approval.mapper.ApprovalMapper;
import com.example.workflowportfolio.leave.mapper.LeaveMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalService {

	private final ApprovalMapper approvalMapper;
	private final LeaveMapper leaveMapper;

	public List<ApprovalWaitingListDto> getWaitingList(Long approverId){
		return approvalMapper.findPendingApproval(approverId);

	}

	public ApprovalDetailDto getDetail(Long leaveId, Long approverId) {
		return approvalMapper.findDetail(leaveId, approverId);
	}

	@Transactional
	public void approve(Long leaveId, Long approverId) {
		int count = approvalMapper.approve(leaveId, approverId);

		if(count == 0) {
			throw new IllegalStateException("承認対象が存在しません。");
		}
		
		int pendingCount = approvalMapper.countPendingByLeaveId(leaveId);
		
		if(pendingCount == 0) {
			leaveMapper.approveLeave(leaveId);
		}

	}
	
	@Transactional
	public void reject(Long leaveId, Long approverId) {
		int count = approvalMapper.reject(leaveId, approverId);
		
		if(count == 0) {
			throw new IllegalStateException("却下対象が存在しません。");
		}
		
		leaveMapper.rejectLeave(leaveId);
	}

}
