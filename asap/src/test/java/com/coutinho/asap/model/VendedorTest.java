package com.coutinho.asap.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coutinho.asap.contants.TIPO_CONTRATACAO;

public class VendedorTest {

	@Test
	@DisplayName("Deveria criar Vendedor sem argumentos")
	public void shouldCreateVendedorWithNoArguments() {
		Vendedor vendedor = new Vendedor();
		assertNotNull(vendedor);
	}

	@Test
	@DisplayName("Deve definir e obter o ID corretamente")
	public void shouldSetAndGetIdCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setId("123");
		assertEquals("123", vendedor.getId());
	}

	@Test
	@DisplayName("Deve definir e obter matrícula corretamente")
	public void shouldSetAndGetMatriculaCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setMatricula("456");
		assertEquals("456", vendedor.getMatricula());
	}

	@Test
	@DisplayName("Deve definir e obter o nome corretamente")
	public void shouldSetAndGetNomeCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Test Name");
		assertEquals("Test Name", vendedor.getNome());
	}

	@Test
	@DisplayName("Deve configurar e obter o dataNascimento corretamente")
	public void shouldSetAndGetDataNascimentoCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setDataNascimento("12/12/2022");
		assertEquals("12/12/2022", vendedor.getDataNascimento());
	}

	@Test
	@DisplayName("Deve definir e obter cpfCnpj corretamente")
	public void shouldSetAndGetCpfCnpjCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setCpfCnpj("529.982.247-25");
		assertEquals("529.982.247-25", vendedor.getCpfCnpj());
		vendedor.toString();
		vendedor.builder().id("1").matricula("123").nome("Test Name").dataNascimento("12/12/2022")
				.cpfCnpj("529.982.247-25").email("teste@gmail.com").build();
	}

	@Test
	@DisplayName("Deve configurar e receber e-mail corretamente")
	public void shouldSetAndGetEmailCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setEmail("test@example.com");
		assertEquals("test@example.com", vendedor.getEmail());
	}

	@Test
	@DisplayName("Deveria configurar e pegar tipoContratacao corretamente")
	public void shouldSetAndGetTipoContratacaoCorrectly() {
		Vendedor vendedor = new Vendedor();
		vendedor.setTipoContratacao(TIPO_CONTRATACAO.CLT);
		assertEquals(TIPO_CONTRATACAO.CLT, vendedor.getTipoContratacao());
	}

	@Test
	@DisplayName("Deve definir e obter filial corretamente")
	public void shouldSetAndGetFilialCorrectly() {
		Vendedor vendedor = new Vendedor();
		Filial filial = new Filial();
		filial.setId("123");
		vendedor.setFilial(filial);
		assertEquals(filial, vendedor.getFilial());
	}
}
