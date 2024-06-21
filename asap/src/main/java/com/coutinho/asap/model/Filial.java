package com.coutinho.asap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filial {
	
	private String id;
	private String nome;
	private String cnpj;
	private String cidade;
	private String uf;
	private String tipo;
	private Boolean ativo;
	private String dataCadastro;
	private String ultimaAtualizacao;
	
}
