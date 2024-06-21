package com.coutinho.asap.service;

import java.util.Objects;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.coutinho.asap.model.MatriculaSequence;

@Service
public class SequenceMatriculaServiceImpl implements SequenceMatriculaService{
	
	private final MongoTemplate mongoTemplate;
	
	public SequenceMatriculaServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Long generateSequence(String seq) {
		MatriculaSequence count = mongoTemplate.findAndModify(new Query(Criteria.where("id").is(seq)), 
															  new Update().inc("seq", 1),
															  new FindAndModifyOptions().returnNew(true).upsert(true), 
															  MatriculaSequence.class);
		
		return !Objects.isNull(count) ? count.getSeq() : 1;
	}

}
