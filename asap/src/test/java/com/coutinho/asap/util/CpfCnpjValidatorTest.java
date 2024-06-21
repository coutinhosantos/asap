package com.coutinho.asap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CpfCnpjValidatorTest {

	private final CpfCnpjValidator validator = new CpfCnpjValidator();

	@Test
	@DisplayName("Deve retornar verdadeiro quando o CPF for válido")
	public void shouldReturnTrueWhenCpfIsValid() {
		assertTrue(validator.isCpf("529.982.247-25"));
	}

	@Test
	@DisplayName("Deve retornar falso quando o CPF for inválido")
	public void shouldReturnFalseWhenCpfIsInvalid() {
		assertFalse(validator.isCpf("123.456.789-10"));
	}

	@Test
	@DisplayName("Deve retornar verdadeiro quando o CNPJ for válido")
	public void shouldReturnTrueWhenCnpjIsValid() {
		assertTrue(validator.isCnpj("11.444.777/0001-61"));
	}

	@Test
	@DisplayName("Deve retornar falso quando o CNPJ for inválido")
	public void shouldReturnFalseWhenCnpjIsInvalid() {
		assertFalse(validator.isCnpj("12.345.678/9012-34"));
	}

}
