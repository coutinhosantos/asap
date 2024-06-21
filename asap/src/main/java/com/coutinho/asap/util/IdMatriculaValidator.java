package com.coutinho.asap.util;

import com.coutinho.asap.annotation.IdMatricula;
import com.coutinho.asap.dto.VendedorDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdMatriculaValidator  implements ConstraintValidator<IdMatricula, VendedorDTO> {

	@Override
	public boolean isValid(VendedorDTO vendedor, ConstraintValidatorContext context) {
		
		if(null!=vendedor.getId() || null!=vendedor.getMatricula()) {
			return true;
		}
		
		return false;
	}

}
