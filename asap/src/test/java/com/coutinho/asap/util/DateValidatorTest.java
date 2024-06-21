package com.coutinho.asap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateValidatorTest {
	
	private final DateValidator validator = new DateValidator();

	@Test
	@DisplayName("Deve retornar verdadeiro quando a data for válida")
	public void shouldReturnTrueWhenDateIsValid() {
		assertTrue(validator.isValid("12/12/2022", null));
	}

	@Test
	@DisplayName("Deve retornar falso quando a data for inválida")
	public void shouldReturnFalseWhenDateIsInvalid() {
		assertFalse(validator.isValid("13/13/2022", null));
	}

	@Test
	@DisplayName("Deve retornar verdadeiro quando a data for nula")
	public void shouldReturnTrueWhenDateIsNull() {
		assertTrue(validator.isValid(null, null));
	}
}
