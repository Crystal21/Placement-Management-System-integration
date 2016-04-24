package org.crce.interns.dao;
import java.util.List;
import org.crce.interns.model.Company;
import org.crce.interns.model.UserCompany;

public interface ManageUsersDao {
	
	public void createDetails(UserCompany user);
	public List<UserCompany> retreiveDetails(String company);
	public List<Company> retrieveCompany_id();
	public void deleteDetails(UserCompany user);
	
}


