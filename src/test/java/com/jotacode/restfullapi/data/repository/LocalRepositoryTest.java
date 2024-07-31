package com.jotacode.restfullapi.data.repository;

import com.jotacode.restfullapi.data.entity.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class LocalRepositoryTest {

    @Autowired
    LocalRepository localRepository;

    @Autowired
    TestEntityManager testEntityManager;

    //Este metodo se ejecuta antes de cada test
    //Se encarga de insertar un registro en la base de datos
    //para que los test puedan ser ejecutados
    @BeforeEach
    void setUp() {
        Local local =
                Local.builder()
                        .name("SuperChiqui")
                        .floor("Piso3")
                        .code("SC03")
                        .build();
        testEntityManager.persist(local);
    }

    @Test
    public void findLocalByNameEqualsIgnoreCase() {
        Optional<Local> local = localRepository.findLocalByNameEqualsIgnoreCase("SuperChiqui");
        assertEquals(local.get().getName(), "SuperChiqui");
        System.out.println(local.get().getName());
    }

    @Test
    public void findLocalByNameEqualsIgnoreCaseNotFound() {
        Optional<Local> local = localRepository.findLocalByNameEqualsIgnoreCase("SuperChiquiNotFound");
        assertEquals(local, Optional.empty());
    }

}