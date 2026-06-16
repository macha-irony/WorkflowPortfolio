package com.example.workflowportfolio.leave.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.workflowportfolio.leave.dto.LeaveListDto;
import com.example.workflowportfolio.leave.entity.Leave;
import com.example.workflowportfolio.leave.form.LeaveApplyForm;
import com.example.workflowportfolio.leave.mapper.LeaveMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveService {
	private final LeaveMapper leaveMapper;
	
	public void apply(LeaveApplyForm form) {
		Leave leave = new Leave();

		//実装まで直接代入
        leave.setApplicantId(1L);
        leave.setLeaveTypeId(form.getLeaveTypeId());
        leave.setApprovalFlowId(1L);
        leave.setStartDate(form.getStartDate());
        leave.setEndDate(form.getEndDate());
        leave.setReason(form.getReason());
        leave.setStatus("PENDING");
        
        leaveMapper.insert(leave);
	}
	
	public List<LeaveListDto> getLeaveList(Long applicantId){
		return leaveMapper.findByApplicantId(applicantId);
	}
}
