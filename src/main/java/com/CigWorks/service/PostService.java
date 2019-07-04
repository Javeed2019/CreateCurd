package com.CigWorks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CigWorks.domain.Post;
import com.CigWorks.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	@Autowired
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}
	
	public Post getLatestPost(){
		return postRepository.findFirstByOrderByPostedOnDesc();
	}

	public List<Post> list() {
		return postRepository.findAllByOrderByPostedOnDesc();
	}

	public Post getBySlug(String slug) {
		return postRepository.findBySlug(slug);
	}

	public List<Post> listByAuthor(Long id) {
		return postRepository.findAllByAuthorIdOrderByPostedOnDesc(id);
	}

	public Object get(Long id) {
		return postRepository.findById(id);
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	public List<Post> AllDetails()
	{
		List<Post> post = null;
		post =(List<Post>) postRepository.findAll();
		return  post;
	}
}
