package com.coutinho.asap.util;

import com.coutinho.asap.annotation.TipoContratacao;
import com.coutinho.asap.contants.TIPO_CONTRATACAO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoContratoValidator implements ConstraintValidator<TipoContratacao, String> {

	@Override
	public boolean isValid(String tipoContratacao, ConstraintValidatorContext context) {
		if (tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.OUT.getDescricao())
				|| tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.CLT.getDescricao())
				|| tipoContratacao.equalsIgnoreCase(TIPO_CONTRATACAO.PJ.getDescricao())) {
			return true;
		}

		return false;
	}
}
