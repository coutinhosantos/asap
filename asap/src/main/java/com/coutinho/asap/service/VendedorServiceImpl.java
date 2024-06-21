package com.coutinho.asap.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.coutinho.asap.annotation.IdMatricula;
import com.coutinho.asap.dto.VendedorDTO;
import com.coutinho.asap.factory.FilialFactory;
import com.coutinho.asap.factory.VendedorFactory;
import com.coutinho.asap.model.Vendedor;
import com.mongodb.client.result.DeleteResult;

@Service
public class VendedorServiceImpl implements VendedorService {

	private final MongoTemplate mongoTemplate;

	private VendedorFactory vendedorFactory;
	
	private FilialFactory filialFactory;

	public VendedorServiceImpl(MongoTemplate mongoTemplate, VendedorFactory vendedorFactory, FilialFactory filialFactory) {
		this.mongoTemplate = mongoTemplate;
		this.vendedorFactory = vendedorFactory;
		this.filialFactory = filialFactory;
	}

	@Override
	public Vendedor cadastrar(VendedorDTO vendedor, Long matricula) {
		return mongoTemplate.save(vendedorFactory.getVendedor(vendedor, matricula,filialFactory.mockFilial("1")));
	}

	@Override
	public Vendedor buscarPorId(String id) {
		return mongoTemplate.findById(id, Vendedor.class);
	}

	@Override
	public Vendedor buscarPorMatricula(String matricula) {
		return mongoTemplate.findOne(new Query().addCriteria(Criteria.where("matricula").in(matricula)), Vendedor.class, "vendedor");
	}
	
	@Override
	public DeleteResult excluirPorMatricula(String matricula) {
		return mongoTemplate.remove(new Query().addCriteria(Criteria.where("matricula").in(matricula)), Vendedor.class);
	}

	@Override
	public DeleteResult excluir(String id) {
		return mongoTemplate.remove(new Query(Criteria.where("id").is(id)), Vendedor.class);
	}

	@IdMatricula
	@Override
	public Vendedor alterar(VendedorDTO vendedor) {
		return mongoTemplate.save(vendedorFactory.getVendedor(vendedor,filialFactory.mockFilial("1")));
	}

	@Override
	public List<Vendedor> listarVendedores() {
		return mongoTemplate.findAll(Vendedor.class);
	}
}
