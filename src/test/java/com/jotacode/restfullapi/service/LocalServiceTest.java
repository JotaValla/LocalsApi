package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.data.repository.LocalRepository;
import com.jotacode.restfullapi.error.LocalNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalServiceTest {

    @Autowired
    private LocalService localService;

    @MockBean
    private LocalRepository localRepository;

    @BeforeEach
    void setUp() {

        Local local = Local.builder()
                .id(1L)
                .name("Petshop")
                .floor("Piso1")
                .code("PS01")
                .build();

        // Trata de simular el comportamiento de la bd para que devuelva el local con el nombre "Petshop"
        Mockito.when(localRepository.findLocalByNameEqualsIgnoreCase("PetShop"))
                .thenReturn(java.util.Optional.of(local));

    }

    @Test
    public void findByNameEqualsIgnoreCaseShouldFound() throws LocalNotFoundException {

        String localName = "Petshop";
        Local local = localService.findLocalByNameEqualsIgnoreCase(localName).get();
        assertEquals(local.getName(), localName);

    }


}