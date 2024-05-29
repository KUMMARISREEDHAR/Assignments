package com.library.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BarrowAndReturn;
import com.library.entity.Book;
import com.library.entity.LibMember;

@Service
public class BarrowAndReturnService {

	@Autowired
	private BookService bservice;
	
	@Autowired
	private LibMemberService lservice;
	
	BarrowAndReturn br = new BarrowAndReturn();
	
	public boolean barrowBook(long memberid, int bookid) {
		Book b = bservice.findBookById(bookid).get();
		LibMember libm = lservice.findLibMemberById(memberid);
		if(b != null && libm != null) {
			br.getBarrowmap().put(libm, b);
			br.setBarrowdate(LocalDate.now());
			return true;
		}
		else
			return false;
	}
	
	public boolean returnBook(long memberid, int bookid) {
		Book b = bservice.findBookById(bookid).get();
		LibMember libm = lservice.findLibMemberById(memberid);
		if(b != null && libm != null) {
			br.getBarrowmap().remove(libm);
			br.setReturndate(LocalDate.now());
			return true;
		}
		else
			return false;
	}
}
