package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Manager;
import com.jotacode.restfullapi.error.ManagerNotFoundException;

import java.util.List;

public interface ManagerService {

    List<Manager> findAllManagers();

    Manager saveManager(Manager manager);

    Manager updateManager(Long id, Manager manager);

    void deleteManager(Long id);

    Manager findById(Long id) throws ManagerNotFoundException;

}
