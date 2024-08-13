package com.jotacode.restfullapi.controller;


import com.jotacode.restfullapi.data.entity.Manager;
import com.jotacode.restfullapi.error.ManagerNotFoundException;
import com.jotacode.restfullapi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    //Operaciones CRUD
    @GetMapping("/managers")
    public List<Manager> findAllManagers() {
        return managerService.findAllManagers();
    }

    @PostMapping("/createManager")
    public Manager saveManager(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @PutMapping("/updateManager/{id}")
    public Manager updateManager(@PathVariable Long id,@RequestBody Manager manager) {
        return managerService.updateManager(id, manager);
    }

    @DeleteMapping("/deleteManager/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }

    @GetMapping("/manager/{id}")
    public Manager findById(@PathVariable Long id) throws ManagerNotFoundException {
        return managerService.findById(id);
    }





}
