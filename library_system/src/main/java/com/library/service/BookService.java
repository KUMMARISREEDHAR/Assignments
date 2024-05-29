package com.library.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Book;
import com.library.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;
	
	public Book saveBook(Book b) {
		return repo.save(b);
	}
	
	public Optional<Book> findBookById(int id) {
		return repo.findById(id);
	}
	
	public Book updateBook(Book b) {
		if((findBookById(b.getId()) != null))
		return repo.save(b);
		else 
			return null;
	}
	
	public void deleteBookById(int id) {
		repo.deleteById(id);
	}
	
	public List<Book> getBooks() {
		return repo.findAll();
	}
	
	public List<Book> sortByTitle() {
		List<Book> list = repo.findAll();
		List<Book> sortList = list.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		return sortList;
	}
	
	public List<Book> sortByAuthor() {
		List<Book> list = repo.findAll();
		return list.stream().sorted(Comparator.comparing(Book::getAuthor)).collect(Collectors.toList());
	}
	
	public List<Book> sortByYear() {
		return repo.findAll().stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.toList());
	}
}
