package com.jotacode.restfullapi.controller;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.error.LocalNotFoundException;
import com.jotacode.restfullapi.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {

    @Autowired
    LocalService localService;

    //OPERACIONES CRUD
    @GetMapping("/locals")
    public List<Local> findAllLocals() {
        return localService.findAllLocals();
    }

    @PostMapping("/createLocal")
    public Local saveLocal(@Valid @RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local) {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/deleteLocal/{id}")
    public void deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
    }

    @GetMapping("/localById/{id}")
    public Local findById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findById(id);
    }
    //Another operations
    @GetMapping("/localByName/{name}")
    public Local findLocalByNameEqualsIgnoreCase(@PathVariable String name) throws LocalNotFoundException {
        return localService.findLocalByNameEqualsIgnoreCase(name).get();
    }

}
