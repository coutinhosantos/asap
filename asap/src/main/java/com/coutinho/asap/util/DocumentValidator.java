package com.coutinho.asap.util;

import com.coutinho.asap.annotation.TipoDocumento;
import com.coutinho.asap.contants.TIPO_CONTRATACAO;
import com.coutinho.asap.dto.VendedorDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentValidator implements ConstraintValidator<TipoDocumento, VendedorDTO> {

	@Override
	public boolean isValid(VendedorDTO vendedor, ConstraintValidatorContext context) {
		
		CpfCnpjValidator cpfCnpjValidator = new CpfCnpjValidator();
		
		if(vendedor.getTipoContratacao().equalsIgnoreCase(TIPO_CONTRATACAO.PJ.getDescricao()) && cpfCnpjValidator.isCnpj(vendedor.getCpfCnpj())) {
			return true;
		}else if(vendedor.getTipoContratacao().equalsIgnoreCase(TIPO_CONTRATACAO.CLT.getDescricao()) && cpfCnpjValidator.isCpf(vendedor.getCpfCnpj())
			   ||vendedor.getTipoContratacao().equalsIgnoreCase(TIPO_CONTRATACAO.OUT.getDescricao()) && cpfCnpjValidator.isCpf(vendedor.getCpfCnpj())) {
			return true;
		}
		
		return false;
	}
}
