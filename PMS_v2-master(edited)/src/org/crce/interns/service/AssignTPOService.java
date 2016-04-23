
package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.springframework.stereotype.Service;

public interface AssignTPOService {
	public void assignTPO(UserDetailsBean userBean);

	public List<UserDetailsBean> viewUsers();

	public void removeTPO(UserDetailsBean userBean);

	void assignTPCF(UserDetailsBean userBean);

}

