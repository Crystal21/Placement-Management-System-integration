<<<<<<< HEAD
package org.crce.interns.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.UserDetails;

public class AddTPCTaskValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return FacultyUser.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		FacultyUserBean fuserBean = (FacultyUserBean) obj;
		System.out.println(fuserBean.getUserName() + " : User Name in Validator");
		System.out.println(fuserBean.getUserWork() + " : User Work in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userWork", "userWork.required");
	}

}
=======
package org.crce.interns.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.UserDetails;

public class AddTPCTaskValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return FacultyUser.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		FacultyUserBean fuserBean = (FacultyUserBean) obj;
		System.out.println(fuserBean.getUserName() + " : User Name in Validator");
		System.out.println(fuserBean.getUserWork() + " : User Work in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userWork", "userWork.required");
	}

}
>>>>>>> darshgup139-master
