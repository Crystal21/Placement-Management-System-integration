package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.springframework.stereotype.Service;

public interface AssignTPOService {
	public int assignTPO(UserDetailsBean userBean);

	public List<UserDetailsBean> viewUsers();

	public int removeTPO(UserDetailsBean userBean);

	public int assignTPCF(UserDetailsBean userBean);

	public int removeTPCF(UserDetailsBean userBean);
}
