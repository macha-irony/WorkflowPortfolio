package com.example.workflowportfolio.leave.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.workflowportfolio.leave.form.LeaveApplyForm;
import com.example.workflowportfolio.leave.service.LeaveService;
import com.example.workflowportfolio.leave.service.LeaveTypeService;
import com.example.workflowportfolio.user.entity.User;

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
	public String applyLeave( @ModelAttribute LeaveApplyForm form, HttpSession session) {
		User loginUser =
	            (User) session.getAttribute("loginUser");
		leaveService.apply(
	            form,
	            loginUser.getId());
		return "redirect:/employee";
	}

	@PostMapping("/{id}/cancel")
	public String cancelLeave(@PathVariable Long id,
								RedirectAttributes redirectAttributes) {
		leaveService.cancelLeave(id);
		redirectAttributes.addFlashAttribute("message", "申請を取り消しました");
		return "redirect:/employee/leave/list";
	}

	@GetMapping("/list")
	public String leaveList(HttpSession session,Model model) {
		User loginUser =
			    (User) session.getAttribute("loginUser");
		model.addAttribute("leaveList", leaveService.getLeaveList(loginUser.getId()));
		return "employee/leave/list";
	}

	@GetMapping("/{id}")
	public String leaveDetail(@PathVariable Long id, Model model) {
		model.addAttribute("leaveDetail", leaveService.getLeaveDetail(id));
		return "employee/leave/detail";
	}
}
