package com.CigWorks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CigWorks.Dao.AuthorDao;
import com.CigWorks.model.Author;

@Service
public class AuthorSerivie {
	
	@Autowired
	private AuthorDao authorDao;

	public List<Author> list()
	{
		return authorDao.findAllByOrderByLastNameAscFirstNameAsc();
	}
}
