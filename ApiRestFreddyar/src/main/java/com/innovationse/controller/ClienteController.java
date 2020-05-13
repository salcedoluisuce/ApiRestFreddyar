package com.innovationse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovationse.model.service.ClienteServiceImpl;
import com.innovationse.exception.ModelNotFoundException;
import com.innovationse.model.entity.Cliente;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		return new ResponseEntity<>(clienteServiceImpl.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteServiceImpl.create(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Cliente cliente) {
		clienteServiceImpl.update(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer idCliente) {
		
Cliente cliente = clienteServiceImpl.findById(idCliente);
		
		if(cliente == null) {
			throw new ModelNotFoundException("El cliente no existe");
		}
		
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idCliente) throws Exception {
		
		Cliente cliente = clienteServiceImpl.findById(idCliente);
		
		if(cliente == null) {
			throw new ModelNotFoundException("El cliente no existe");
		}
		
		clienteServiceImpl.delete(idCliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
