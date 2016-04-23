package org.crce.interns.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.crce.interns.beans.FeedbackBean;
import org.crce.interns.model.Feedback;

//@Component("feedbackFormValidator")
public class FeedbackFormValidator implements Validator {

	 //which objects can be validated by this validator
    @Override
    public boolean supports(Class<?> paramClass) {
        return Feedback.class.equals(paramClass);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
        
    	FeedbackBean feedback = (FeedbackBean) obj;

       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company","company.required");
         
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feeback","feeback.required");
        if(feedback.getFeeback().length() >500)
		{
			errors.rejectValue("feeback","feeback.size");
		}
        
    }
}
