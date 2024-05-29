package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.entity.LibMember;
import com.library.service.BarrowAndReturnService;
import com.library.service.BookService;
import com.library.service.LibMemberService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	private BookService service;
	
	@Autowired
	private LibMemberService libservice;
	
	@Autowired
	private BarrowAndReturnService brservice;

	
	//crud operations on book
	
	@PostMapping("/books")
	public Book save(@RequestBody Book b) {
		return service.saveBook(b);
	}
	
	@GetMapping("/books/{id}")
	public Book find(@PathVariable int id) {
		return service.findBookById(id).get();
	}
	
	@GetMapping("/books")
	public List<Book> getBookList() {
		return service.getBooks();
	}
	
	@PutMapping("/books")
	public Book update(@RequestBody Book b) {
		return service.updateBook(b);
	}
	
	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable int id) {
		service.deleteBookById(id);
	}
	
	//library member crud
	
	@PostMapping("/members")
	public LibMember save(@RequestBody LibMember lib) {
		return libservice.save(lib);
	}
	
	@GetMapping("/members")
	public List<LibMember> getAllLibMember() {
		return libservice.getAll();
	}
	
	@GetMapping("/members/{id}")
	public LibMember findById(@PathVariable long id) {
		return libservice.findLibMemberById(id);
	}
	
	@PutMapping("/members/{id}")
	public LibMember update(@RequestBody LibMember lib) {
		return libservice.update(lib);
	}
	
	@DeleteMapping("/members/{id}")
	public void delete(@PathVariable long id) {
		libservice.delete(id);
	}
	
	//barrow and return books
	
	@GetMapping("/borrow/{bookid}/{libid}")
	public ResponseEntity<String> barrowBook(@PathVariable int bookid, @PathVariable long libid) {
		LibMember libMeber = libservice.findLibMemberById(libid);
		Book book = service.findBookById(bookid).get();
		
		if(libMeber != null && book != null) {
			boolean result = brservice.barrowBook(libMeber.getId(), book.getId());
			if(result) {
				return new ResponseEntity<>("Book borrowed successfully", HttpStatus.OK);
			}
			else 
				return new ResponseEntity<>("Book is not available for borrowing", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("LibMember or Book not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/return/{bookid}/{libid}")
	public ResponseEntity<String> returnBook(@PathVariable int bookid, @PathVariable long libid) {
		LibMember libMeber = libservice.findLibMemberById(libid);
		Book book = service.findBookById(bookid).get();
		
		if(libMeber != null && book != null) {
			boolean result = brservice.returnBook(libMeber.getId(), book.getId());
			if(result) {
				return new ResponseEntity<>("Book returned successfully", HttpStatus.OK);
			}
			else 
				return new ResponseEntity<>("Book is not returned", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("LibMember or Book not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/sortByTitle")
	public List<Book> sortByTitle() {
		return service.sortByTitle();
	}
	
	@GetMapping("/sortByAuthor")
	public List<Book> sortByAuthor() {
		return service.sortByAuthor();
	}
	
	@GetMapping("/sortByYear")
	public List<Book> sortByYear() {
		return service.sortByYear();
	}
}
