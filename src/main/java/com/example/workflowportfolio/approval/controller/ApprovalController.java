package com.example.workflowportfolio.approval.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.workflowportfolio.approval.service.ApprovalService;
import com.example.workflowportfolio.user.entity.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee/approval")
public class ApprovalController {

	private final ApprovalService approvalService;

	@GetMapping("/waiting")
	public String waitingList(HttpSession session, Model model) {
		
		User loginUser =
			    (User) session.getAttribute("loginUser");

		model.addAttribute(
				"approvalList",
				approvalService.getWaitingList(loginUser.getId())
				);

		return "employee/approval/waiting-list";
	}

	@GetMapping("/{leaveId}")
	public String detail(@PathVariable Long leaveId, HttpSession session,
			Model model) {
		User loginUser =
			    (User) session.getAttribute("loginUser");

		model.addAttribute("approvalDetail", approvalService.getDetail(leaveId, loginUser.getId()));
		return "employee/approval/detail";
	}

	@PostMapping("/{leaveId}/approve")
	public String approve(@PathVariable Long leaveId,HttpSession session,
			RedirectAttributes redirectAttributes) {
		User loginUser =
			    (User) session.getAttribute("loginUser");
		approvalService.approve(leaveId, loginUser.getId());
		redirectAttributes.addFlashAttribute("message", "申請を承認しました。");
		return "redirect:/employee/approval/waiting";
	}

	@PostMapping("/{leaveId}/reject")
	public String reject(@PathVariable Long leaveId,HttpSession session,
			RedirectAttributes redirectAttributes) {
		User loginUser =
			    (User) session.getAttribute("loginUser");
		approvalService.reject(leaveId, loginUser.getId());
		redirectAttributes.addFlashAttribute("message", "申請を却下しました。");
		return "redirect:/employee/approval/waiting";
	}
}
