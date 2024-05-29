package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.LibMember;
import com.library.repository.LibMemberRepo;

@Service
public class LibMemberService {

	@Autowired
	private LibMemberRepo repo;
	
	public LibMember save(LibMember lib) {
		return repo.save(lib);
	}
	
	public LibMember findLibMemberById(long id) {
		return repo.findById(id);
	}
	
	public LibMember update(LibMember lib) {
		if((findLibMemberById(lib.getId())) != null)
			return repo.save(lib);
		else
			return null;
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public List<LibMember> getAll() {
		return repo.findAll();
	}
	
}
