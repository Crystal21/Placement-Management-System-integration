package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.UserDetails;

public interface SearchDao {
	
	public List<UserDetails> searchUser(String searchString);
	public UserDetails viewProfile(String userName);
}
