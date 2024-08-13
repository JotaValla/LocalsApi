package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.data.entity.Order;
import com.jotacode.restfullapi.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local> findAllLocals();

    Local saveLocal(Local local);

    Local updateLocal(Long id, Local local);

    void deleteLocal(Long id);

    Local findById(Long id) throws LocalNotFoundException;

    Optional<Local> findLocalByNameEqualsIgnoreCase(String name) throws LocalNotFoundException;

    Local createLocalWithOrder(Local local, List<Order> orders);

    Local addOrdersToLocal(Long localId, List<Order> orders) throws LocalNotFoundException;


}
