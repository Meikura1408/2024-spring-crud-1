package com.example.spring_boot_test4.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double saldo = 0;

    public ContoBancario() {}

    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositare(double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("L'importo da depositare deve essere positivo.");
        }
        saldo += importo;
    }

    public void prelevare(double importo) {
        if (importo > saldo) {
            throw new IllegalArgumentException("Fondi insufficienti.");
        }
        saldo -= importo;
    }
}
