package com.practico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practico.Dao.IDaoCliente;
import com.practico.Entity.Cliente;

@RestController
@RequestMapping(value = "/api")
public class clienteController {
	
	@Autowired
	private IDaoCliente DaoCliente;
	
	@GetMapping (value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll (){
		return DaoCliente.findAll();
	}
	
	@GetMapping(value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
		Cliente cliente = DaoCliente.findById(id);
		if (cliente != null) {
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping (value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente save (@RequestBody Cliente cliente) {
		return DaoCliente.save(cliente);
	}
	
	@PutMapping (value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente update (@RequestBody Cliente cliente) {
		return DaoCliente.update(cliente);
	}

}
