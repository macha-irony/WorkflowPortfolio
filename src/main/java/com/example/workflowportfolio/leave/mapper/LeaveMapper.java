package com.example.workflowportfolio.leave.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.workflowportfolio.leave.entity.Leave;

@Mapper
public interface LeaveMapper {
	int insert(Leave leave);
}
