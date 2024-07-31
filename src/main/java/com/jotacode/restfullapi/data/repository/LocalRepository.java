package com.jotacode.restfullapi.data.repository;

import com.jotacode.restfullapi.data.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

    //Query Methods
    Optional<Local> findLocalByNameEqualsIgnoreCase(String name);

}
