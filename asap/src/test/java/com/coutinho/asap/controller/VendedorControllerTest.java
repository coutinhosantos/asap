package com.coutinho.asap.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Vendedor;
import com.coutinho.asap.service.SequenceMatriculaService;
import com.coutinho.asap.service.VendedorService;

public class VendedorControllerTest {

	@InjectMocks
    private VendedorController vendedorController;

    @Mock
    private VendedorService vendedorService;

    @Mock
    private SequenceMatriculaService sequenceMatriculaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Deve registrar o vendedor com sucesso")
    @Test
    public void shouldRegisterSellerSuccessfully() {
        VendedorDTO vendedorDTO = new VendedorDTO();
        Vendedor vendedor = new Vendedor();
        when(vendedorService.cadastrar(any(VendedorDTO.class), any(Long.class))).thenReturn(vendedor);
        ResponseEntity<Vendedor> response = vendedorController.cadastrar(vendedorDTO);
        assertEquals(200, response.getStatusCodeValue());
    }
    
    @DisplayName("Deve buscar o vendedor por identificação com sucesso")
    @Test
    public void shouldFetchSellerByIdSuccessfully() {
        Vendedor vendedor = new Vendedor();
        when(vendedorService.buscarPorId(any(String.class))).thenReturn(vendedor);
        ResponseEntity<Vendedor> response = vendedorController.buscarPorId("1");
        assertEquals(200, response.getStatusCodeValue());
    }

    @DisplayName("Deve buscar o vendedor por matrícula com sucesso")
    @Test
    public void shouldFetchSellerByMatriculaSuccessfully() {
        Vendedor vendedor = new Vendedor();
        when(vendedorService.buscarPorMatricula(any(String.class))).thenReturn(vendedor);
        ResponseEntity<Vendedor> response = vendedorController.buscarPorMatricula("1");
        assertEquals(200, response.getStatusCodeValue());
    }

    @DisplayName("Deve excluir o vendedor por matrícula com sucesso")
    @Test
    public void shouldDeleteSellerByMatriculaSuccessfully() {
        when(vendedorService.excluirPorMatricula(any(String.class))).thenReturn(null);
        vendedorController.excluirPorMatricula("1");
    }

    @DisplayName("Deve excluir o vendedor por ID com sucesso")
    @Test
    public void shouldDeleteSellerByIdSuccessfully() {
        when(vendedorService.excluir(any(String.class))).thenReturn(null);
        vendedorController.excluirVendedorPorId("1");
    }

    @DisplayName("Deve atualizar o vendedor com sucesso")
    @Test
    public void shouldUpdateSellerSuccessfully() {
        VendedorDTO vendedorDTO = new VendedorDTO();
        Vendedor vendedor = new Vendedor();
        when(vendedorService.alterar(any(VendedorDTO.class))).thenReturn(vendedor);
        ResponseEntity<Vendedor> response = vendedorController.alterarVendedor(vendedorDTO);
        assertEquals(200, response.getStatusCodeValue());
    }
    
    @Test
    @DisplayName("Deve listar todos os vendedores com sucesso")
    public void shouldListAllSellers() {
        Vendedor vendedor1 = new Vendedor();
        Vendedor vendedor2 = new Vendedor();
        List<Vendedor> vendedores = Arrays.asList(vendedor1, vendedor2);
        when(vendedorService.listarVendedores()).thenReturn(vendedores);
        ResponseEntity<List<Vendedor>> response = vendedorController.listarVendedores();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(vendedores, response.getBody());
    }

}
