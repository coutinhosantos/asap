package com.coutinho.asap.factory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import com.coutinho.asap.model.Filial;

import reactor.core.publisher.Mono;

public class FilialFactoryImplTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private FilialFactoryImpl filialFactory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    @DisplayName("Deve retornar Filial quando um ID válido for fornecido")
    public void shouldReturnFilialWhenValidIdIsProvided() {
        Filial expectedFilial = new Filial();
        when(responseSpec.bodyToMono(Filial.class)).thenReturn(Mono.just(expectedFilial));

        Filial actualFilial = filialFactory.mockFilial("validId");

        assertEquals(expectedFilial, actualFilial);
    }

    @Test
    @DisplayName("Deve retornar nulo quando um ID inválido for fornecido")
    public void shouldReturnNullWhenInvalidIdIsProvided() {
        when(responseSpec.bodyToMono(Filial.class)).thenReturn(Mono.empty());

        Filial actualFilial = filialFactory.mockFilial("invalidId");

        assertNull(actualFilial);
    }
}