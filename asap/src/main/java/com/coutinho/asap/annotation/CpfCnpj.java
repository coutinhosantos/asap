package com.coutinho.asap.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.coutinho.asap.util.CpfCnpjValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { CpfCnpjValidator.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CpfCnpj {
	String message() default "CPF/CNPJ inválido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
