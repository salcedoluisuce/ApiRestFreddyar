package com.innovationse.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovationse.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
