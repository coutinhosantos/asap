package com.coutinho.asap.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatriculaSequenceTest {

	@Test
	@DisplayName("Deveria criar MatriculaSequence sem argumentos")
	public void shouldCreateMatriculaSequenceWithNoArguments() {
		MatriculaSequence matriculaSequence = new MatriculaSequence();
		assertNotNull(matriculaSequence);
	}

	@Test
	@DisplayName("Deve definir e obter o ID corretamente")
	public void shouldSetAndGetIdCorrectly() {
		MatriculaSequence matriculaSequence = new MatriculaSequence();
		matriculaSequence.setId("123");
		assertEquals("123", matriculaSequence.getId());
	}

	@Test
	@DisplayName("Deve definir e obter seq corretamente")
	public void shouldSetAndGetSeqCorrectly() {
		MatriculaSequence matriculaSequence = new MatriculaSequence("1", Long.valueOf(123));
		assertEquals(Long.valueOf(123), matriculaSequence.getSeq());
	}
	
	@Test
	@DisplayName("Deveria criar MatriculaSequence com todos os argumentos")
	public void shouldCreateMatriculaSequenceWithAllArguments() {
		MatriculaSequence.builder().id("1").seq(Long.valueOf(123)).build();
		assertNotNull(MatriculaSequence.builder().id("1").seq(Long.valueOf(123)).build());
	}

}
