package com.coutinho.asap.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.coutinho.asap.util.DocumentValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { DocumentValidator.class })
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface TipoDocumento {
	String message() default "Documento inválido, Para pessoas jurídicas(PJ) utilize CNPJ para e os demais utilize CPF";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
