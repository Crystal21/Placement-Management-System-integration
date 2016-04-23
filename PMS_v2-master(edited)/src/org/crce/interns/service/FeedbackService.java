package org.crce.interns.service;

import java.util.List;

import org.crce.interns.model.*;



public interface FeedbackService {
	
	
	public List<Feedback> listFeedback();
	public void addFeedback(Feedback feedback);

	}
