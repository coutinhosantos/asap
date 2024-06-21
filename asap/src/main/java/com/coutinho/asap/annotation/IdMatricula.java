package com.coutinho.asap.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.coutinho.asap.util.IdMatriculaValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { IdMatriculaValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface IdMatricula {
	String message() default "Para alterar é necessário preencher o campo Id ou a Matricula do Vendedor";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
