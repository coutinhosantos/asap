package com.coutinho.asap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsapApplicationTests {

	@Test
	@DisplayName("Deve carregar o contexto do Spring sem erros")
	public void shouldLoadSpringContextWithoutErrors() {
		AsapApplication.main(new String[] {});
	}

}
