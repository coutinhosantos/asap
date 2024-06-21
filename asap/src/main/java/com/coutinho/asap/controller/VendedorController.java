package com.coutinho.asap.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Vendedor;
import com.coutinho.asap.service.SequenceMatriculaService;
import com.coutinho.asap.service.VendedorService;
import com.mongodb.client.result.DeleteResult;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/vendedor")
public class VendedorController {

	private VendedorService service;
	
	private SequenceMatriculaService matriculaService;

	@Operation(summary = "Cadastro de Vendedor", description = "Api responsável por cadastrar o Vendedor")
	@PostMapping("/cadastrar")
	public ResponseEntity<Vendedor> cadastrar(@Valid @RequestBody VendedorDTO vendedor) {
		return ResponseEntity.ok(service.cadastrar(vendedor, matriculaService.generateSequence(Vendedor.SEQUENCE_NAME)));
	}
	
	@Operation(summary = "Busca de Vendedor por id", description = "Api responsável por buscar o Vendedor a partir do id")
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Vendedor> buscarPorId(@NotNull @PathVariable("id") String id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@Operation(summary = "Busca de Vendedor por Matricula", description = "Api responsável por buscar o Vendedor a partir da Matricula")
	@GetMapping("/buscarPorMatricula/{matricula}")
	public ResponseEntity<Vendedor> buscarPorMatricula(@NotNull @PathVariable("matricula") String matricula) {
		return ResponseEntity.ok(service.buscarPorMatricula(matricula));
	}
	
	@Operation(summary = "Exclusão de Vendedor por Matricula", description = "Api responsável por excluir o Vendedor a partir da Matricula")
	@DeleteMapping("/excluirPorMatricula/{matricula}")
	public DeleteResult excluirPorMatricula(@NotNull @PathVariable("matricula") String matricula) {
		return service.excluirPorMatricula(matricula);
	}

	@Operation(summary = "Exclusão de Vendedor por id", description = "Api responsável por excluir o Vendedor a partir do id")
	@DeleteMapping("/excluir/{id}")
	public DeleteResult excluirVendedorPorId(@NotNull @PathVariable("id") String id) {
		return service.excluir(id);
	}

	@Operation(summary = "Alteração de Vendedor", description = "Api responsável por alterar os dados do Vendedor")
	@PutMapping("/alterar")
	public ResponseEntity<Vendedor> alterarVendedor(@Valid @RequestBody VendedorDTO vendedor) {
		return ResponseEntity.ok(service.alterar(vendedor));
	}

	@Operation(summary = "Listagem de Vendedores", description = "Api responsável por exibir a lista de Vendedores")
	@GetMapping("/listar")
	public ResponseEntity<List<Vendedor>> listarVendedores() {
		return ResponseEntity.ok(service.listarVendedores());
	}
}
