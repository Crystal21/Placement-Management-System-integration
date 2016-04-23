package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.*;


public interface FeedbackDao {

	public List<Feedback> listFeedback();
	public void addFeedback(Feedback feedback);

}
