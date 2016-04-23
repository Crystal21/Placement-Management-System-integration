package org.crce.interns.exception;

public class MaxFileSizeExceededError extends Exception{

	public String toString(){
		return("Failed to upload...File size can be only upto 512KB");
	}
}
