
package com.CigWorks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CigWorks.service.PostService;

@Controller
public class HomeController 
{
	@Autowired
	private PostService PostService;

	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("post", PostService.getLatesPosts());
		return "index";
	}
	
//	@RequestMapping("/login")
//	public String login()
//	{
//		return "auth/login";
//	}
	
	
}
