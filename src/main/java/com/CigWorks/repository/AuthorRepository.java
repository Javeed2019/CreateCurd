package com.CigWorks.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CigWorks.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findAllByOrderByLastNameAscFirstNameAsc();

}