package com.example.workflowportfolio.leave.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.workflowportfolio.leave.entity.LeaveType;
import com.example.workflowportfolio.leave.mapper.LeaveTypeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveTypeService {
	
	private final LeaveTypeMapper leaveTypeMapper;
	
	public List<LeaveType> findAll(){
		return leaveTypeMapper.findAll();
	}
}
