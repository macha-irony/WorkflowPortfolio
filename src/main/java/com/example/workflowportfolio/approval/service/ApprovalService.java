package com.example.workflowportfolio.approval.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.workflowportfolio.approval.dto.ApprovalWaitingListDto;
import com.example.workflowportfolio.approval.mapper.ApprovalMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalService {

		private final ApprovalMapper approvalMapper;

		public List<ApprovalWaitingListDto> getWaitingList(Long approverId){
			return approvalMapper.findPendingApproval(approverId);
			
		}
}
