package com.example.workflowportfolio.leave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.workflowportfolio.leave.form.LeaveApplyForm;
import com.example.workflowportfolio.leave.service.LeaveService;
import com.example.workflowportfolio.leave.service.LeaveTypeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/employee/leave")
@RequiredArgsConstructor
public class LeaveController {
	
	private final LeaveTypeService leaveTypeService;
	private final LeaveService leaveService;
	
	@GetMapping("/apply")
	public String applyLeave(Model model) {
		model.addAttribute("leaveApplyForm", new LeaveApplyForm());
		model.addAttribute("leaveTypes", leaveTypeService.findAll());
		return "employee/leave/apply";
	}
	
	@PostMapping("/apply")
	public String applyLeave( @ModelAttribute LeaveApplyForm form) {
		leaveService.apply(form);
		return "redirect:/employee";
	}

}
