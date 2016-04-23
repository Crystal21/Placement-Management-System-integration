package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.service.SearchService;
import org.crce.interns.dao.SearchDao;
import org.crce.interns.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("searchServiceImpl")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao seachDao;
	
	@Override
	public List<UserDetails> searchUser(String searchString) {
		List<UserDetails> userList = seachDao.searchUser(searchString);
		return userList;
	}

	@Override
	public UserDetails viewProfile(String userName) {
		UserDetails user = seachDao.viewProfile(userName);
		return user;
	}

}
