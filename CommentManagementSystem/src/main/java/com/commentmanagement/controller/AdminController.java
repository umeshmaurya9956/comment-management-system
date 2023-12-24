package com.commentmanagement.controller;

import org.aspectj.weaver.ast.HasAnnotation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

	@GetMapping("/")
	@PreAuthorize("has")
	public String getAdmin()
	{
		System.out.println("welcome admin page");
		return "welcome";
	}
}
