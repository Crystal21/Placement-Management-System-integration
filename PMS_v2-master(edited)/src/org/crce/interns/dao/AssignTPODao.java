package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.UserDetails;

public interface AssignTPODao {
	public void assignTPO(UserDetails user);

	public List<UserDetails> viewUsers();

	public void removeTPO(UserDetails user);

	public UserDetails getUser(UserDetails checkUser);

}
