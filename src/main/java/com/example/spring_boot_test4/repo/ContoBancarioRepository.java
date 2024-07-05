package com.example.spring_boot_test4.repo;

import com.example.spring_boot_test4.pojo.ContoBancario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContoBancarioRepository extends JpaRepository<ContoBancario, Long> {
}
