package com.coutinho.asap.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.coutinho.asap.model.MatriculaSequence;

public class SequenceMatriculaServiceImplTest {
	@InjectMocks
	private SequenceMatriculaServiceImpl sequenceService;

	@Mock
	private MongoTemplate mongoTemplate;

	@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	@DisplayName("Deve gerar uma nova sequência com sucesso")
	public void shouldGenerateNewSequence() {
		String seq = "seq";
		MatriculaSequence matriculaSequence = new MatriculaSequence();
		matriculaSequence.setSeq(1L);
		when(mongoTemplate.findAndModify(new Query(Criteria.where("id").is(seq)), new Update().inc("seq", 1),
										 new FindAndModifyOptions()
										 .returnNew(true)
										 .upsert(true), MatriculaSequence.class))
										 .thenReturn(matriculaSequence);
		Long response = sequenceService.generateSequence(seq);
		assertEquals(1L, response);
	}

	@Test
	@DisplayName("Deve retornar 1 quando a sequência for nula")
	public void shouldReturnOneWhenSequenceIsNull() {
		String seq = "seq";
		when(mongoTemplate.findAndModify(new Query(Criteria.where("id").is(seq)), new Update().inc("seq", 1),
										 new FindAndModifyOptions().returnNew(true)
										 						   .upsert(true), MatriculaSequence.class))
																   .thenReturn(null);
		Long response = sequenceService.generateSequence(seq);
		assertEquals(1L, response);
	}

}
