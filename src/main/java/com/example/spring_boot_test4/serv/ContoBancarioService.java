package com.example.spring_boot_test4.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_test4.pojo.ContoBancario;
import com.example.spring_boot_test4.repo.ContoBancarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepository repository;

    public void save(ContoBancario contoBancario) {
       repository.save(contoBancario);
    }

    public Optional<ContoBancario> getContoBancarioById(int id) {
        return repository.findById(id);
    }

    public List<ContoBancario> getAllContoBancario() {
        return repository.findAll();
    }

    public ContoBancario update(int id, ContoBancario updatedContoBancario) {
        Optional<ContoBancario> existingContoBancario = repository.findById(id);
        if (existingContoBancario.isPresent()) {
            updatedContoBancario.setId(id);
            return repository.save(updatedContoBancario);
        } else {
            throw new RuntimeException("Conto bancario non trovato con ID: " + id);
        }
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
