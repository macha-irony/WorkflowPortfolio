package com.example.workflowportfolio.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workflowportfolio.approval.service.ApprovalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee/approval")
public class ApprovalController {

	private final ApprovalService approvalService;
	
	@GetMapping("/waiting")
	public String waitingList(Model model) {
		// 仮ログインユーザー
        Long approverId = 1L;
        
        model.addAttribute(
                "approvalList",
                approvalService.getWaitingList(approverId)
            );
        
        return "employee/approval/waiting-list";
	}
}
