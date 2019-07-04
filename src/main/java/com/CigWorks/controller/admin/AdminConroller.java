package com.CigWorks.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CigWorks.model.Post;
import com.CigWorks.service.AuthorSerivie;
import com.CigWorks.service.PostService;

@Controller
@Secured({"ROLE_ADMIN"})
public class AdminConroller 
{

	
	private PostService postService;
	
	@Autowired
	private AuthorSerivie authorSerivie;

	@Autowired
	public AdminConroller(PostService postService) {
		super();
		this.postService = postService;
	}
	
	
	@RequestMapping("/admin/posts")
	public String list(Model model)
	{
		model.addAttribute("posts", postService.list());
		return "admin/post/list";
	}
	

	@RequestMapping(value = "/admin/post/{id}" ,method = RequestMethod.GET)
	public String view(@PathVariable Long id,Model model)
	{
		model.addAttribute("post", postService.get(id));
		return "admin/post/view";
	}
	
	
	@RequestMapping(value = "/admin/post/create", method = RequestMethod.GET)
	public String create(Model model)
	{
		model.addAttribute("post", new Post());
		model.addAttribute(	"authors",authorSerivie.list());
		return "admin/post/postForm";
	}
	
	@RequestMapping(value = "/getAllDetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllDetails() 
	{
		List<Post> post= null;
		post= postService.AllDetails();
		
		return new ResponseEntity<List<Post>>(post, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/post/save", method = RequestMethod.POST)
	public String Save(@Valid Post post,BindingResult BindingResult,Model model )
	{
		if(BindingResult.hasErrors())
		{
			//model.addAttribute(	"authors",authorSerivie.list());
			return "admin/post/postForm";
		}
		else
		{
			postService.save(post);
			return "admin/post/SavedFile";
		}
	}
	
	@RequestMapping("/admin/post/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		//model.addAttribute("authors", authorService.list());		
		return "admin/post/postForm";
	}
	
	@RequestMapping("/admin/post/delete/{id}")
	public String delete(@PathVariable Long id,RedirectAttributes attributes)
	{
		postService.delete(id);
		attributes.addFlashAttribute("message","Post was Deleted");
		
		return "redirect:/admin/posts";
	}
}

