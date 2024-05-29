package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

	public List<Book> findAll();
}
