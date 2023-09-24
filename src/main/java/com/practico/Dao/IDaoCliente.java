package com.practico.Dao;

import java.util.List;

import com.practico.Entity.Cliente;

public interface IDaoCliente {
	public List<Cliente> findAll();
	public Cliente findById(int id);
	public Cliente save(Cliente cliente);
	public Cliente update(Cliente cliente);
}
