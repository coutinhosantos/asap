package com.coutinho.asap.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.coutinho.asap.contants.TIPO_CONTRATACAO;
import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Filial;
import com.coutinho.asap.model.Vendedor;

public class VendedorFactoryImplTest {
	private final VendedorFactoryImpl factory = new VendedorFactoryImpl();

	@Test
	@DisplayName("Deve criar Vendedor com VendedorDTO e Filial válidos")
	public void shouldCreateVendedorWithValidVendedorDTOAndFilial() {
		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setId("123");
		vendedorDTO.setMatricula("456");
		vendedorDTO.setNome("Test Name");
		vendedorDTO.setDataNascimento("12/12/2022");
		vendedorDTO.setCpfCnpj("529.982.247-25");
		vendedorDTO.setEmail("test@example.com");
		vendedorDTO.setTipoContratacao("CLT");

		Filial filial = new Filial();

		Vendedor vendedor = factory.getVendedor(vendedorDTO, filial);

		assertNotNull(vendedor);
		assertEquals("123", vendedor.getId());
		assertEquals("456", vendedor.getMatricula());
		assertEquals("Test Name", vendedor.getNome());
		assertEquals("12/12/2022", vendedor.getDataNascimento());
		assertEquals("52998224725", vendedor.getCpfCnpj());
		assertEquals("test@example.com", vendedor.getEmail());
		assertEquals(filial, vendedor.getFilial());
	}

	@Test
	@DisplayName("Deverá criar Vendedor com VendedorDTO válido, matrícula e Filial")
	public void shouldCreateVendedorWithValidVendedorDTOMatriculaAndFilial() {
		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setId("123");
		vendedorDTO.setNome("Test Name");
		vendedorDTO.setDataNascimento("12/12/2022");
		vendedorDTO.setCpfCnpj("529.982.247-25");
		vendedorDTO.setEmail("test@example.com");
		vendedorDTO.setTipoContratacao("CLT");

		Filial filial = new Filial();

		Vendedor vendedor = factory.getVendedor(vendedorDTO, 456L, filial);

		assertNotNull(vendedor);
		assertEquals("123", vendedor.getId());
		assertEquals("Test Name", vendedor.getNome());
		assertEquals("12/12/2022", vendedor.getDataNascimento());
		assertEquals("52998224725", vendedor.getCpfCnpj());
		assertEquals("test@example.com", vendedor.getEmail());
		assertEquals(filial, vendedor.getFilial());
	}

	@Test
	@DisplayName("Deve retornar OUTSOURCING quando tipoContratacao for OUTSOURCING")
	public void shouldReturnOutsourcingWhenTipoContratacaoIsOutsourcing() {
		assertEquals(TIPO_CONTRATACAO.OUT, factory.getTipoContratacao("OUT"));
	}

	@Test
	@DisplayName("Deve retornar CLT quando tipoContratacao for CLT")
	public void shouldReturnCltWhenTipoContratacaoIsClt() {
		assertEquals(TIPO_CONTRATACAO.CLT, factory.getTipoContratacao("CLT"));
	}

	@Test
	@DisplayName("Deveria retornar PJ quando tipoContratacao for PJ")
	public void shouldReturnPjWhenTipoContratacaoIsPj() {
		assertEquals(TIPO_CONTRATACAO.PJ, factory.getTipoContratacao("PJ"));
	}

	@Test
	@DisplayName("Deve retornar nulo quando tipoContratacao for inválido")
	public void shouldReturnNullWhenTipoContratacaoIsInvalid() {
		assertNull(factory.getTipoContratacao("INVALID"));
	}
}
