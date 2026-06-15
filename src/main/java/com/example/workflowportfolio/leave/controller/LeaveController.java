package com.example.workflowportfolio.leave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workflowportfolio.leave.form.LeaveApplyForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/employee/leave")
@RequiredArgsConstructor
public class LeaveController {
	@GetMapping("/apply")
	public String applyLeave(Model model) {
		model.addAttribute("leaveApplyForm", new LeaveApplyForm());
		return "employee/leave/apply";
	}

}
