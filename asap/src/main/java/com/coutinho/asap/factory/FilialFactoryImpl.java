package com.coutinho.asap.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.coutinho.asap.model.Filial;

@Component
public class FilialFactoryImpl implements FilialFactory{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FilialFactoryImpl.class);
	
	private final WebClient webClient;
	
	public FilialFactoryImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Filial mockFilial(String id) {
		LOGGER.info("GET    REQUEST  - URL: {} ", "/Filial/" + id);
        Filial filial =  webClient.get()
                                  .uri("/Filial/" + id)
                                  .retrieve()
                                  .bodyToMono(Filial.class)
                                  .block();
        LOGGER.info("GET    RESPONSE - URL: {} - RESPONSE BODY: {}", "/Filial/" + id, filial);
        return filial;
	}



	

}
