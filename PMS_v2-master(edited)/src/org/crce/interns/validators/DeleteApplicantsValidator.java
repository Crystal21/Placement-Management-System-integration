package org.crce.interns.validators;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.model.UserCompany;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DeleteApplicantsValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return UserCompany.class.equals(paramClass); 
		//return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		UserCompanyBean userBean = (UserCompanyBean) obj;
	//	System.out.println(userBean.getUsername() + " : User Name in Validator");
	//	System.out.println(userBean.getCompany() + " : Company Name in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "company.required");

		
	}

}
