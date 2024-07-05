package com.example.spring_boot_test4;

import com.example.spring_boot_test4.pojo.ContoBancario;
import com.example.spring_boot_test4.serv.ContoBancarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest4Application.class, args);
	}

	@Autowired
    private ContoBancarioService contoBancarioService;

    @Override
    public void run(String... args) throws Exception {
       
        ContoBancario conto = new ContoBancario();
        conto = contoBancarioService.createContoBancario(conto);

        try {
            
            conto.depositare(100);
            contoBancarioService.updateContoBancario(conto.getId(), conto);

            conto.prelevare(50);
            contoBancarioService.updateContoBancario(conto.getId(), conto);

            ContoBancario retrievedConto = contoBancarioService.getContoBancario(conto.getId());
            System.out.println("Saldo attuale: " + retrievedConto.getSaldo());

            contoBancarioService.deleteContoBancario(conto.getId());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
