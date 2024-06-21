package com.coutinho.asap.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.coutinho.asap.annotation.ValidDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {
	
	@Override
	public boolean isValid(String date, ConstraintValidatorContext context) {
		try {
			if(null!=date) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate.parse(date, formatter);
			}
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
