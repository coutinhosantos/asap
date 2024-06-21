package com.coutinho.asap.contants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TIPO_CONTRATACAO {
	
	OUT("OUT"), CLT("CLT"), PJ("PJ");
	private final String descricao;
}
