package com.example.workflowportfolio.leave.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.workflowportfolio.approval.entity.Approval;
import com.example.workflowportfolio.approval.entity.ApprovalFlowStep;
import com.example.workflowportfolio.approval.mapper.ApprovalFlowStepMapper;
import com.example.workflowportfolio.approval.mapper.ApprovalMapper;
import com.example.workflowportfolio.leave.dto.LeaveDetailDto;
import com.example.workflowportfolio.leave.dto.LeaveListDto;
import com.example.workflowportfolio.leave.entity.Leave;
import com.example.workflowportfolio.leave.form.LeaveApplyForm;
import com.example.workflowportfolio.leave.mapper.LeaveMapper;
import com.example.workflowportfolio.user.entity.User;
import com.example.workflowportfolio.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveService {
	private final UserMapper userMapper;
	private final LeaveMapper leaveMapper;
	private final ApprovalMapper approvalMapper;
	private final ApprovalFlowStepMapper approvalFlowStepMapper;

	@Transactional
	public void apply(LeaveApplyForm form) {
		Leave leave = new Leave();

		//実装まで直接代入
		leave.setApplicantId(1L);
		leave.setLeaveTypeId(form.getLeaveTypeId());
		leave.setFlowId(1L);
		leave.setStartDate(form.getStartDate());
		leave.setEndDate(form.getEndDate());
		leave.setReason(form.getReason());
		leave.setStatus("PENDING");

		leaveMapper.insert(leave);

		/*
		 * 承認フロー定義をもとに承認レコードを生成
		 */
		List<ApprovalFlowStep> steps = approvalFlowStepMapper.findByFlowId(leave.getFlowId());

		for(ApprovalFlowStep step : steps) {

			User approver = userMapper.findByPositionId(step.getApproverPositionId());

			if(approver == null) {
				throw new IllegalStateException(
						"承認者が存在しません。position_id :"
								+ step.getApproverPositionId());
			}

			Approval approval = new Approval();

			//実装まで直接代入
			approval.setLeaveId(leave.getId());
			approval.setApproverId(approver.getId());
			approval.setStepNo(step.getStepNo());
			approval.setStatus("PENDING");

			approvalMapper.insert(approval);

		}
	}

	public void cancelLeave(Long id) {
		leaveMapper.cancel(id);
	}

	public List<LeaveListDto> getLeaveList(Long applicantId){
		return leaveMapper.findByApplicantId(applicantId);
	}

	public LeaveDetailDto getLeaveDetail(Long id) {
		return leaveMapper.findDetailById(id);
	}
}
