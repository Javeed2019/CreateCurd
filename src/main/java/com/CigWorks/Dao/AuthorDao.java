package com.CigWorks.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CigWorks.model.Author;


public interface AuthorDao extends CrudRepository<Author, Long> {
	
	List<Author> findAllByOrderByLastNameAscFirstNameAsc();

}
