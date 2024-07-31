package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.error.LocalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long id, Local local);

    void deleteLocal(Long id);

    Local findById(Long id) throws LocalNotFoundException;

    Optional<Local> findLocalByNameEqualsIgnoreCase(String name) throws LocalNotFoundException;


}
