package com.example.workflowportfolio.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/{leaveId}")
	public String detail(@PathVariable Long leaveId, 
						Model model) {
		//実装まで固定値
		Long approverId = 1L;
		
		model.addAttribute("approvalDetail", approvalService.getDetail(leaveId, approverId));
		return "employee/approval/detail";
	}
	
	@PostMapping("/{leaveId}/approve")
	public String approve(@PathVariable Long leaveId,
							RedirectAttributes redirectAttributes) {
		//実装まで固定値
				Long approverId = 1L;
		approvalService.approve(leaveId, approverId);
		redirectAttributes.addFlashAttribute("message", "申請を承認しました。");
		return "redirect:/employee/approval/waiting";
	}
}
