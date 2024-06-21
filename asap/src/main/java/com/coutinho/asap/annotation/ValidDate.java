package com.coutinho.asap.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.coutinho.asap.util.DateValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { DateValidator.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ValidDate {
	String message() default "Formato de Data Inválido, favor inserir data no formato dd/MM/yyyy";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
