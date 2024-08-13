package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Manager;
import com.jotacode.restfullapi.data.repository.ManagerRepository;
import com.jotacode.restfullapi.error.ManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ManagerServiceImpl implements  ManagerService{

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> findAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Long id, Manager manager) {
        Manager managerToUpdate = managerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Manager not found with id: " + id));
        if (Objects.nonNull(manager.getFirstName()) && !"".equalsIgnoreCase(manager.getFirstName())) {
            managerToUpdate.setFirstName(manager.getFirstName());
        }
        if (Objects.nonNull(manager.getLastName()) && !"".equalsIgnoreCase(manager.getLastName())) {
            managerToUpdate.setLastName(manager.getLastName());
        }
        //for address for city
        if(Objects.nonNull(manager.getAddress().getCity()) && !"".equalsIgnoreCase(manager.getAddress().getCity())){
            managerToUpdate.getAddress().setCity(manager.getAddress().getCity());
        }
        //main street
        if(Objects.nonNull(manager.getAddress().getMainStreet()) && !"".equalsIgnoreCase(manager.getAddress().getMainStreet())){
            managerToUpdate.getAddress().setMainStreet(manager.getAddress().getMainStreet());
        }
        //second street
        if(Objects.nonNull(manager.getAddress().getSecondStreet()) && !"".equalsIgnoreCase(manager.getAddress().getSecondStreet())){
            managerToUpdate.getAddress().setSecondStreet(manager.getAddress().getSecondStreet());
        }
        return managerRepository.save(managerToUpdate);

    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Manager findById(Long id) throws ManagerNotFoundException {
        return managerRepository.findById(id).orElseThrow(() -> new ManagerNotFoundException("Manager not found with id: " + id));
    }
}
