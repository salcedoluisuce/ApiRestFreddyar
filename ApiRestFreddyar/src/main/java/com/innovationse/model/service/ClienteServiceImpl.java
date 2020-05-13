package com.innovationse.model.service;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovationse.model.entity.Cliente;
import com.innovationse.model.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente findById(Integer id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		return clienteOptional.orElse(null);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}

}
