package com.coutinho.asap.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.factory.FilialFactory;
import com.coutinho.asap.factory.VendedorFactory;
import com.coutinho.asap.model.Vendedor;
import com.mongodb.client.result.DeleteResult;

public class VendedorServiceImplTest {
	@InjectMocks
	private VendedorServiceImpl vendedorService;

	@Mock
	private MongoTemplate mongoTemplate;

	@Mock
	private VendedorFactory vendedorFactory;

	@Mock
	private FilialFactory filialFactory;
	
	@Mock
	DeleteResult deleteResult;
	
	@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	@DisplayName("Deve registrar um vendedor com sucesso")
	public void shouldRegisterSeller() {
		VendedorDTO vendedorDTO = new VendedorDTO();
		Vendedor vendedor = new Vendedor();
		when(vendedorFactory.getVendedor(vendedorDTO, 1L, filialFactory.mockFilial("1"))).thenReturn(vendedor);
		when(mongoTemplate.save(vendedor)).thenReturn(vendedor);
		Vendedor response = vendedorService.cadastrar(vendedorDTO, 1L);
		assertNotNull(response);
		assertEquals(vendedor, response);
	}

	@Test
	@DisplayName("Deve listar todos os vendedores com sucesso")
	public void shouldListAllSellers() {
		Vendedor vendedor1 = new Vendedor();
		Vendedor vendedor2 = new Vendedor();
		List<Vendedor> vendedores = Arrays.asList(vendedor1, vendedor2);
		when(mongoTemplate.findAll(Vendedor.class)).thenReturn(vendedores);
		List<Vendedor> response = vendedorService.listarVendedores();
		assertNotNull(response);
		assertEquals(vendedores, response);
	}

	@Test
	@DisplayName("Deve excluir um vendedor por ID com sucesso")
	public void shouldDeleteSellerById() {
		when(mongoTemplate.remove(new Query(Criteria.where("id").is("1")), Vendedor.class)).thenReturn(deleteResult);
		DeleteResult response = vendedorService.excluir("1");
		assertNotNull(response);
	}
	
	@Test
	@DisplayName("Deve devolver um vendedor quando o ID for válido")
	public void shouldReturnSellerWhenIdIsValid() {
	    String id = "1";
	    Vendedor vendedor = new Vendedor();
	    when(mongoTemplate.findById(id, Vendedor.class)).thenReturn(vendedor);
	    Vendedor response = vendedorService.buscarPorId(id);
	    assertNotNull(response);
	    assertEquals(vendedor, response);
	}

	@Test
	@DisplayName("Deve retornar nulo quando o id não for válido")
	public void shouldReturnNullWhenIdIsNotValid() {
	    String id = "invalid";
	    when(mongoTemplate.findById(id, Vendedor.class)).thenReturn(null);
	    Vendedor response = vendedorService.buscarPorId(id);
	    assertEquals(null, response);
	}
	
	@Test
	@DisplayName("Deve devolver um vendedor quando a matrícula for válida")
	public void shouldReturnSellerWhenMatriculaIsValid() {
	    String matricula = "12345";
	    Vendedor vendedor = new Vendedor();
	    when(mongoTemplate.findOne(new Query().addCriteria(Criteria.where("matricula").in(matricula)), Vendedor.class, "vendedor")).thenReturn(vendedor);
	    Vendedor response = vendedorService.buscarPorMatricula(matricula);
	    assertNotNull(response);
	    assertEquals(vendedor, response);
	}

	@Test
	@DisplayName("Deve retornar nulo quando a matrícula não for válida")
	public void shouldReturnNullWhenMatriculaIsNotValid() {
	    String matricula = "invalid";
	    when(mongoTemplate.findOne(new Query().addCriteria(Criteria.where("matricula").in(matricula)), Vendedor.class, "vendedor")).thenReturn(null);
	    Vendedor response = vendedorService.buscarPorMatricula(matricula);
	    assertEquals(null, response);
	}

	@Test
	@DisplayName("Deve excluir um vendedor por matrícula com sucesso")
	public void shouldDeleteSellerByMatricula() {
	    String matricula = "12345";
	    when(mongoTemplate.remove(new Query().addCriteria(Criteria.where("matricula").in(matricula)), Vendedor.class)).thenReturn(deleteResult);
	    DeleteResult response = vendedorService.excluirPorMatricula(matricula);
	    assertNotNull(response);
	    assertEquals(deleteResult, response);
	}

	@Test
	@DisplayName("Deve atualizar um vendedor com sucesso")
	public void shouldUpdateSeller() {
	    VendedorDTO vendedorDTO = new VendedorDTO();
	    Vendedor vendedor = new Vendedor();
	    when(mongoTemplate.save(vendedorFactory.getVendedor(vendedorDTO, filialFactory.mockFilial("1")))).thenReturn(vendedor);
	    Vendedor response = vendedorService.alterar(vendedorDTO);
	    assertNotNull(response);
	    assertEquals(vendedor, response);
	}

	@Test
	@DisplayName("Deve retornar nulo quando a atualização falhar")
	public void shouldReturnNullWhenUpdateFails() {
	    VendedorDTO vendedorDTO = new VendedorDTO();
	    when(mongoTemplate.save(vendedorFactory.getVendedor(vendedorDTO, filialFactory.mockFilial("1")))).thenReturn(null);
	    Vendedor response = vendedorService.alterar(vendedorDTO);
	    assertEquals(null, response);
	}
}
