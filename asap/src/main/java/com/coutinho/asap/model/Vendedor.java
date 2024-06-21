package com.coutinho.asap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.coutinho.asap.contants.TIPO_CONTRATACAO;
import com.google.gson.annotations.SerializedName;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "vendedor")
public class Vendedor {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private String id;

	@Field(name = "matricula")
	@SerializedName("matricula")
	@NotNull(message = "A matricula não pode ser nula")
	private String matricula;

	@Field(name = "nome")
	@SerializedName("nome")
	private String nome;

	@Field(name = "dataNascimento")
	@SerializedName("dataNascimento")
	private String dataNascimento;

	@Field(name = "cpfCnpj")
	@SerializedName("cpfCnpj")
	private String cpfCnpj;

	@Field(name = "email")
	@SerializedName("email")
	private String email;

	@Field(name = "tipoContratacao")
	@SerializedName("tipoContratacao")
	private TIPO_CONTRATACAO tipoContratacao;

	@Field(name = "filial")
	@SerializedName("filial")
	private Filial filial;

}
