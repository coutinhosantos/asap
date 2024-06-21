package com.coutinho.asap.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilialTest {
	@Test
	@DisplayName("Deveria criar Filial sem argumentos")
	public void shouldCreateFilialWithNoArguments() {
		Filial filial = new Filial();
		assertNotNull(filial);
	}

	@Test
	@DisplayName("Deve definir e obter o ID corretamente")
	public void shouldSetAndGetIdCorrectly() {
		Filial filial = new Filial();
		filial.setId("123");
		assertEquals("123", filial.getId());
	}

	@Test
	@DisplayName("Deve definir e obter o nome corretamente")
	public void shouldSetAndGetNomeCorrectly() {
		Filial filial = new Filial();
		filial.setNome("Test Name");
		assertEquals("Test Name", filial.getNome());
	}

	@Test
	@DisplayName("Deve configurar e obter o cnpj corretamente")
	public void shouldSetAndGetCnpjCorrectly() {
		Filial filial = new Filial();
		filial.setCnpj("529.982.247-25");
		assertEquals("529.982.247-25", filial.getCnpj());
	}

	@Test
	@DisplayName("Deve definir e obter cidade corretamente")
	public void shouldSetAndGetCidadeCorrectly() {
		Filial filial = new Filial();
		filial.setCidade("Test City");
		assertEquals("Test City", filial.getCidade());
	}

	@Test
	@DisplayName("Deve definir e obter uf corretamente")
	public void shouldSetAndGetUfCorrectly() {
		Filial filial = new Filial();
		filial.setUf("Test UF");
		assertEquals("Test UF", filial.getUf());
	}

	@Test
	@DisplayName("Deve definir e obter o tipo corretamente")
	public void shouldSetAndGetTipoCorrectly() {
		Filial filial = new Filial();
		filial.setTipo("Test Type");
		assertEquals("Test Type", filial.getTipo());
	}

	@Test
	@DisplayName("Deve configurar e obter ativo corretamente")
	public void shouldSetAndGetAtivoCorrectly() {
		Filial filial = new Filial();
		filial.setAtivo(true);
		assertEquals(true, filial.getAtivo());
	}

	@Test
	@DisplayName("Deve configurar e obter o dataCadastro corretamente")
	public void shouldSetAndGetDataCadastroCorrectly() {
		Filial filial = new Filial();
		filial.setDataCadastro("12/12/2022");
		assertEquals("12/12/2022", filial.getDataCadastro());
	}

	@Test
	@DisplayName("Deve configurar e obter a ultima Atualizacao corretamente")
	public void shouldSetAndGetUltimaAtualizacaoCorrectly() {
		Filial filial = new Filial();
		filial.setUltimaAtualizacao("12/12/2022");
		assertEquals("12/12/2022", filial.getUltimaAtualizacao());
	}
	
	@Test
	@DisplayName("Deveria criar Filial com todos os argumentos")
	public void shouldCreateFilialWithAllArguments() {
		Filial.builder().id("1").nome("Test Name").cnpj("529.982.247-25").cidade("Test City").uf("Test UF")
				.tipo("Test Type").ativo(true).dataCadastro("12/12/2022").ultimaAtualizacao("12/12/2022").build();
		assertNotNull(Filial.builder().id("1").nome("Test Name").cnpj("529.982.247-25").cidade("Test City")
				.uf("Test UF").tipo("Test Type").ativo(true).dataCadastro("12/12/2022").ultimaAtualizacao("12/12/2022")
				.build());
	}
	
	@Test
	@DisplayName("Deveria criar Filial com todos os argumentos")
	public void builder() {
		Filial.builder().id("1").nome("Test Name").cnpj("529.982.247-25").cidade("Test City").uf("Test UF")
				.tipo("Test Type").ativo(true).dataCadastro("12/12/2022").ultimaAtualizacao("12/12/2022").build();

		Filial.builder().id("1").nome("Test Name").cnpj("529.982.247-25").cidade("Test City").uf("Test UF");
	}

}
