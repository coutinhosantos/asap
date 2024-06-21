package com.coutinho.asap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coutinho.asap.dto.VendedorDTO;

public class VendedorDTOTest {
	@Test
	@DisplayName("Deveria criar VendedorDTO sem argumentos")
	public void shouldCreateVendedorDTOWithNoArguments() {
		VendedorDTO vendedor = new VendedorDTO();
		assertNotNull(vendedor);
	}

	@Test
	@DisplayName("Deve definir e obter o ID corretamente")
	public void shouldSetAndGetIdCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setId("123");
		assertEquals("123", vendedor.getId());
	}

	@Test
	@DisplayName("Deve definir e obter matrícula corretamente")
	public void shouldSetAndGetMatriculaCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setMatricula("456");
		assertEquals("456", vendedor.getMatricula());
	}

	@Test
	@DisplayName("Deve definir e obter o nome corretamente")
	public void shouldSetAndGetNomeCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setNome("Test Name");
		assertEquals("Test Name", vendedor.getNome());
	}

	@Test
	@DisplayName("Deve configurar e obter o dataNascimento corretamente")
	public void shouldSetAndGetDataNascimentoCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setDataNascimento("12/12/2022");
		assertEquals("12/12/2022", vendedor.getDataNascimento());
	}

	@Test
	@DisplayName("Deve definir e obter cpfCnpj corretamente")
	public void shouldSetAndGetCpfCnpjCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setCpfCnpj("529.982.247-25");
		assertEquals("52998224725", vendedor.getCpfCnpj());
	}

	@Test
	@DisplayName("Deve configurar e receber e-mail corretamente")
	public void shouldSetAndGetEmailCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setEmail("test@example.com");
		assertEquals("test@example.com", vendedor.getEmail());
	}

	@Test
	@DisplayName("Deveria configurar e pegar tipoContratacao corretamente")
	public void shouldSetAndGetTipoContratacaoCorrectly() {
		VendedorDTO vendedor = new VendedorDTO();
		vendedor.setTipoContratacao("CLT");
		assertEquals("CLT", vendedor.getTipoContratacao());
	}
}
