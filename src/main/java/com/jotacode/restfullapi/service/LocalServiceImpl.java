package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Local;
import com.jotacode.restfullapi.data.repository.LocalRepository;
import com.jotacode.restfullapi.error.LocalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localToUpdate = localRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Local not found with id: " + id));
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localToUpdate.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localToUpdate.setFloor(local.getFloor());
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localToUpdate.setName(local.getName());
        }
        return localRepository.save(localToUpdate);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Local findById(Long id) throws LocalNotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if (!local.isPresent()) {
            throw new LocalNotFoundException("Local not found with id: " + id);
        }
        return local.get();
    }

    @Override
    public Optional<Local> findLocalByNameEqualsIgnoreCase(String name) {
        return localRepository.findLocalByNameEqualsIgnoreCase(name);
    }
}
