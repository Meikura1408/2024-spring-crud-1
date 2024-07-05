package com.example.spring_boot_test4;

import com.example.spring_boot_test4.pojo.ContoBancario;
import com.example.spring_boot_test4.serv.ContoBancarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTest4Application implements CommandLineRunner {

    @Autowired
    private ContoBancarioService contoBancarioService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTest4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        ContoBancario conto = new ContoBancario();
        contoBancarioService.create(conto);

        ContoBancario letto = contoBancarioService.read(conto.getId()).orElseThrow();
        System.out.println(letto);

        letto.deposita(100);
        contoBancarioService.update(letto.getId(), letto);
        System.out.println(contoBancarioService.read(letto.getId()).orElseThrow());

        letto.preleva(50);
        contoBancarioService.update(letto.getId(), letto);
        System.out.println(contoBancarioService.read(letto.getId()).orElseThrow());

        contoBancarioService.delete(letto.getId());
    }
}
