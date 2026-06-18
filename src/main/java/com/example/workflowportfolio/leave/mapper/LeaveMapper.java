package com.example.workflowportfolio.leave.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.workflowportfolio.leave.dto.LeaveDetailDto;
import com.example.workflowportfolio.leave.dto.LeaveListDto;
import com.example.workflowportfolio.leave.entity.Leave;

@Mapper
public interface LeaveMapper {
	int insert(Leave leave);
	int cancel(Long id);
	List<LeaveListDto> findByApplicantId(Long applicantId);
	LeaveDetailDto findDetailById(Long id);
}
