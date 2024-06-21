package com.coutinho.asap.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class TipoContratoValidatorTest {
	
	@InjectMocks
	private TipoContratoValidator validator;
	
	@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	@DisplayName("Deve retornar verdadeiro quando o tipo de contrato for válido")
	public void shouldReturnTrueWhenContractTypeIsValid() {
		assertTrue(validator.isValid("CLT", null));
		assertTrue(validator.isValid("PJ", null));
		assertTrue(validator.isValid("OUT", null));
	}

	@Test
	@DisplayName("Deve retornar falso quando o tipo de contrato for inválido")
	public void shouldReturnFalseWhenContractTypeIsInvalid() {
		assertFalse(validator.isValid("INVALID", null));
	}
}
