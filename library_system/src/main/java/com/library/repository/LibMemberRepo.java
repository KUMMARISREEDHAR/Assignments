package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.LibMember;

@Repository
public interface LibMemberRepo extends CrudRepository<LibMember, Long>{

	public List<LibMember> findAll();
	
	public LibMember findById(long id);
}
