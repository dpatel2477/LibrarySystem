package com.lmsMgmt.models.validators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lmsMgmt.models.Book;


@Component
@Qualifier("bookValidator")
public class BookValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Book.class);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookTitle", "msg.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbin", "msg.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishDate", "msg.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authors", "msg.field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "msg.field.required");
	}

}
