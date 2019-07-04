package com.CigWorks.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CigWorks.model.Post;
import com.CigWorks.request.PostRequest;

public interface PostDao extends CrudRepository<Post, Long>
{
	
	Post findFirstByOrderByPostedOnDesc();
	
	List<Post> findAllByOrderByPostedOnDesc();
	
	Post findBySlug(String slug);
	
	List<Post> findAllByAuthorIdOrderByPostedOnDesc(long id);

	Post findById(long id);

	PostRequest save(PostRequest post);
	
	Post deleteById(long id);
	

	

	

}
