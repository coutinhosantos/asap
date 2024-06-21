package com.coutinho.asap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "matricula_sequences")
public class MatriculaSequence {
	
	@Transient
    public static final String SEQUENCE_MATRICULA = "matricula_sequence";

	@Id
	private String id;

	private Long seq;
}
