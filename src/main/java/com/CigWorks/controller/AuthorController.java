package com.CigWorks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CigWorks.service.AuthorSerivie;

@Controller
@RequestMapping("/authors")
public class AuthorController 
{
	@Autowired
	private AuthorSerivie servies;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("authors", servies.list());
		return "author/list";
	}
	
	@RequestMapping("/view")
	public String view(Model model) {
		return "author/view";
	}

	@RequestMapping("/create")
	public String create(Model model)
	{
		return "";
	}
	
}
