package com.coutinho.asap.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.coutinho.asap.util.TipoContratoValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = { TipoContratoValidator.class })
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface TipoContratacao {
	String message() default "Valor de tipo de contrato inválido, o tipo de contratação aceita os valores CLT, PJ E OUT";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
