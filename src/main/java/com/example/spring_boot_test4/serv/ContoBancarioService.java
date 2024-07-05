package com.example.spring_boot_test4.serv;

import com.example.spring_boot_test4.pojo.ContoBancario;
import com.example.spring_boot_test4.repo.ContoBancarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepository contoBancarioRepository;

    public ContoBancario createContoBancario(ContoBancario contoBancario) {
        return contoBancarioRepository.save(contoBancario);
    }

    public ContoBancario getContoBancario(Long id) {
        return contoBancarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conto bancario non trovato"));
    }

    public List<ContoBancario> getAllContiBancari() {
        return contoBancarioRepository.findAll();
    }

    public ContoBancario updateContoBancario(Long id, ContoBancario updatedContoBancario) {
        ContoBancario contoBancario = getContoBancario(id);
       
        double nuovoSaldo = updatedContoBancario.getSaldo();
        if (nuovoSaldo >= 0) {
            contoBancario.depositare(nuovoSaldo - contoBancario.getSaldo());
        }
        return contoBancarioRepository.save(contoBancario);
    }

    public void deleteContoBancario(Long id) {
        contoBancarioRepository.deleteById(id);
    }
}
