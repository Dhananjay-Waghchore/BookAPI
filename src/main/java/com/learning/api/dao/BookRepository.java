package com.learning.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.learning.api.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);
	
}
