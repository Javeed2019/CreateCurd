package com.CigWorks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CigWorks.Dao.PostDao;
import com.CigWorks.model.Post;
import com.CigWorks.request.PostRequest;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;

	
	public Post getLatesPosts()
	{
		return postDao.findFirstByOrderByPostedOnDesc();
	}
	
	public List<Post> list()
	{
		return postDao.findAllByOrderByPostedOnDesc();
	}
	
	public Post getBySlug(String slug)
	{
		return postDao.findBySlug(slug);
	}
	
	public List<Post> listByAuthor(long id)
	{
		return postDao.findAllByAuthorIdOrderByPostedOnDesc(id);
	}

	public Post get(long id) {
		
		return postDao.findById(id);
	}
	
	public List<Post> AllDetails()
	{
		List<Post> post = null;
		post =(List<Post>) postDao.findAll();
		return  post;
	}

	public Post save(Post post) {
		
		return postDao.save(post);
	}

	public PostRequest save(PostRequest post) {
		// TODO Auto-generated method stub
		return postDao.save(post);
	}
	
	public Post delete(long id)
	{
		return postDao.deleteById(id);
	}
}

