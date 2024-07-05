package com.example.spring_boot_test4;

import com.example.spring_boot_test4.pojo.ContoBancario;
import com.example.spring_boot_test4.serv.ContoBancarioService;

import java.util.Optional;
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
        
        try {
            System.out.println("-----------------------------------");
            ContoBancario conto1 = new ContoBancario();

            conto1.deposita(32);
            conto1.deposita(21);
            conto1.preleva(32);
            contoBancarioService.save(conto1);
            System.out.println(conto1);

            System.out.println("-----------------------------------");
            ContoBancario conto2 = new ContoBancario();

            conto2.deposita(421);
            conto2.preleva(321);
            contoBancarioService.save(conto2);
            System.out.println(conto2);

            System.out.println("-----------------------------------");
            ContoBancario conto3 = new ContoBancario();
            contoBancarioService.save(conto3);
            System.out.println(conto3);

            System.out.println("-----------------------------------");
            contoBancarioService.getAllContoBancario().forEach(System.out::println);

            Optional<ContoBancario> oldCBOpt = contoBancarioService.getContoBancarioById(3);

            if (oldCBOpt.isEmpty()) {
                System.out.println("Conto inesistente");
                return;
            }
            ContoBancario oldCB = oldCBOpt.get();
            System.out.println(oldCB);
            oldCB.setId(0);

            // ELIMINO UN CONTO
            Optional<ContoBancario> delCB = contoBancarioService.getContoBancarioById(3);
            if (delCB.isEmpty()) {
                System.out.println("Conto inesistente");
                return;
            }  
            contoBancarioService.delete(3);
            
            System.out.println("-----------------------------------");
            contoBancarioService.getAllContoBancario().forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
