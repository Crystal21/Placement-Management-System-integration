package org.crce.interns.exception;

public class IncorrectFileFormatException extends Exception {
	
	/*String s2;
	IncorrectFileFormatException(String s1){
		s2 = s1;
	}*/

	public String toString(){
		return("Failed to upload...File format can be docx/pdf/odt only!");
	}
}
