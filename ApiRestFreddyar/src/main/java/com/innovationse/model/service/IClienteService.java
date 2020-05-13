package com.innovationse.model.service;

import java.util.List;

import com.innovationse.model.entity.Cliente;

public interface IClienteService {
	
	Cliente create(Cliente cliente);
	
	Cliente update(Cliente cliente);
	
	Cliente findById(Integer id);
	
	List<Cliente> findAll();
	
	void delete(Integer id);

}
