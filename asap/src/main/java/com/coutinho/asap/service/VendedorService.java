package com.coutinho.asap.service;

import java.util.List;

import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.model.Vendedor;
import com.mongodb.client.result.DeleteResult;

public interface VendedorService {
	public Vendedor cadastrar(VendedorDTO vendedor, Long matricula);
	public Vendedor buscarPorId(String id);
	public Vendedor buscarPorMatricula(String matricula);
	public DeleteResult excluirPorMatricula(String matricula);
	public DeleteResult excluir(String id);
	public Vendedor alterar(VendedorDTO vendedor);
	public List<Vendedor> listarVendedores();
}
