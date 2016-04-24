package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.Allotment;

public interface ManageAllotmentDao {

	public void createAllotment(Allotment allotment);

	public List<Allotment> listAllotment();
	

}
