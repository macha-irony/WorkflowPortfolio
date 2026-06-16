package com.example.workflowportfolio.leave.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.workflowportfolio.leave.entity.LeaveType;
@Mapper
public interface LeaveTypeMapper {
	List<LeaveType> findAll();
	
}
