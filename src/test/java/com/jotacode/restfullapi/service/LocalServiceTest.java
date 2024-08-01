package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.data.repository.LocalRepository;
import com.jotacode.restfullapi.error.LocalNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestPropertySource(properties = {
        "server.port=8080",
        "spring.datasource.url=jdbc:postgresql://localhost:5432/apiLocals_test",
        "spring.datasource.username=jota",
        "spring.datasource.password=jotacode"
})
@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;

    @MockBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {

        Local local = Local.builder()
                .id(2L)
                .name("Petshop")
                .floor("Piso1")
                .code("PS01")
                .build();

        // Trata de simular el comportamiento de la bd para que devuelva el local con el nombre "Petshop"
        Mockito.when(localRepository.findLocalByNameEqualsIgnoreCase("Petshop"))
                .thenReturn(Optional.of(local));

    }

    @Test
    @DisplayName("Prueba de buscar local por nombre con éxito")
    public void findByNameEqualsIgnoreCaseShouldFound() throws LocalNotFoundException {
        String localName = "Petshop"; // Asegúrate de que este nombre coincida con la simulación
        Optional<Local> optionalLocal = localService.findLocalByNameEqualsIgnoreCase(localName);

        // Verifica si el Optional tiene un valor presente
        assertTrue(optionalLocal.isPresent(), "El Optional no debe estar vacío");

        // Obtén el valor del Optional
        Local local = optionalLocal.get();
        assertEquals(localName, local.getName(), "El nombre del local debe coincidir");
    }


}