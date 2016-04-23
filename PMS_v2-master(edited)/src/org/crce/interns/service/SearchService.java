package org.crce.interns.service;

import java.util.List;

import org.crce.interns.model.UserDetails;

public interface SearchService {

	public List<UserDetails> searchUser(String searchString);
	public UserDetails viewProfile(String userName);
}
