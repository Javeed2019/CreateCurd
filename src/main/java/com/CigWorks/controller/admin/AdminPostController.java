package com.CigWorks.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.CigWorks.domain.Post;
import com.CigWorks.service.AuthorService;
import com.CigWorks.service.PostService;

@Controller
@Secured( {"ROLE_ADMIN"} )
public class AdminPostController {
	
	private PostService postService;
	private AuthorService authorService;
	
	@Autowired
	public AdminPostController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}
	
	@RequestMapping("/admin/posts")
	public String list(Model model) {
		model.addAttribute("posts", postService.list());
		return "admin/post/list";
	}
	
	@RequestMapping("/admin/post/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		return "admin/post/view";
	}
	
	
	@RequestMapping(value = "/getAllDetails", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getExamsDetails(@RequestParam Long id) 
	{
		List<Post> post= null;
		post= postService.AllDetails();
		
		return new ResponseEntity<List<Post>>(post, HttpStatus.OK);
	}
	
	// create | save
	
	@RequestMapping("/admin/post/create")
	public String create(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("authors", authorService.list());
		return "admin/post/postForm";
	}
	
	@RequestMapping( value = "/admin/post/save", method = RequestMethod.POST )
	public String save(Post post) {
		Post savedPost = postService.save(post);
		return "redirect:/admin/post/" + savedPost.getId();
	}
}
