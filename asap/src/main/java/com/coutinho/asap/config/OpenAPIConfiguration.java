package com.coutinho.asap.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {
	
	@Bean
	public OpenAPI defineOpenApi() {
		
		Server server = new Server();
		server.setUrl("http://localhost:8080");
		server.setDescription("Desafio Técnico ASAP - Casas Bahia");
		
		Contact myContact = new Contact();
		myContact.setName("Jefferson Coutinho");
		myContact.setEmail("coutinho_santos@yahoo.com.br");

		Info information = new Info().title("Cadastro de Vendedores")
									 .version("1.0")
									 .description("Api de cadastro de Vendedores")
									 .contact(myContact);
		
		return new OpenAPI().info(information).servers(List.of(server));
	}
}
