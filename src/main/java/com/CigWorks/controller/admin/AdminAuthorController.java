package com.CigWorks.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CigWorks.service.AuthorSerivie;

@Controller
@Secured({"ROLE_ADMIN"})
public class AdminAuthorController {
	
	@Autowired
	private AuthorSerivie authorSerivie;
	
	@GetMapping("/admin/auhots")
	public String list(Model model)
	{
		model.addAttribute("authors", authorSerivie.list());
		System.out.println("*****"+authorSerivie.list().toString()+"********");
		return "admin/author/list";
	}

}
