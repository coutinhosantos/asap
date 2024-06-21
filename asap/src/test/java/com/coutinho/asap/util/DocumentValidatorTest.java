package com.coutinho.asap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coutinho.asap.contants.TIPO_CONTRATACAO;
import com.coutinho.asap.dto.VendedorDTO;

public class DocumentValidatorTest {
	private final DocumentValidator validator = new DocumentValidator();

	@Test
	@DisplayName("Deve retornar verdadeiro quando o documento for CPF válido e o tipo de contrato for CLT")
	public void shouldReturnTrueWhenDocumentIsValidCpfAndContractTypeIsClt() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setCpfCnpj("529.982.247-25");
		vendedor.setTipoContratacao(TIPO_CONTRATACAO.CLT.getDescricao());
		assertTrue(validator.isValid(vendedor, null));
	}

	@Test
	@DisplayName("Deve retornar verdadeiro quando o documento for CNPJ válido e o tipo de contrato for PJ")
	public void shouldReturnTrueWhenDocumentIsValidCnpjAndContractTypeIsPj() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setCpfCnpj("11.444.777/0001-61");
		vendedor.setTipoContratacao(TIPO_CONTRATACAO.PJ.getDescricao());
		assertTrue(validator.isValid(vendedor, null));
	}

	@Test
	@DisplayName("Deve retornar falso quando o documento for CPF inválido e o tipo de contrato for CLT")
	public void shouldReturnFalseWhenDocumentIsInvalidCpfAndContractTypeIsClt() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setCpfCnpj("123.456.789-10");
		vendedor.setTipoContratacao(TIPO_CONTRATACAO.CLT.getDescricao());
		assertFalse(validator.isValid(vendedor, null));
	}

	@Test
	@DisplayName("Deve retornar falso quando o documento for CNPJ inválido e o tipo de contrato for PJ")
	public void shouldReturnFalseWhenDocumentIsInvalidCnpjAndContractTypeIsPj() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setCpfCnpj("12.345.678/9012-34");
		vendedor.setTipoContratacao(TIPO_CONTRATACAO.PJ.getDescricao());
		assertFalse(validator.isValid(vendedor, null));
	}
}
