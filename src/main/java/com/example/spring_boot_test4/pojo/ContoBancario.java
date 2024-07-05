package com.example.spring_boot_test4.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int saldo;

    public ContoBancario() {
        setSaldo(0);
    }

    public int getSaldo() {
        return saldo;
    }

    private void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void deposita(int importo) throws IllegalArgumentException {
        if (importo <= 0) {
            throw new IllegalArgumentException("L'importo deve essere maggiore di zero");
        }
        setSaldo(getSaldo() + importo);
    }

    public void preleva(int importo) throws IllegalArgumentException {
        if (saldo - importo < 0) {
            throw new IllegalArgumentException("Non puoi prelevare più di quanto hai");
        }
        setSaldo(getSaldo() - importo);
    }

    @Override
    public String toString() {
        return "Saldo: " + getSaldo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
