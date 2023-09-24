package com.practico.Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practico.Dao.IDaoCliente;
import com.practico.Entity.Cliente;


@Repository
@Transactional
public class DaoCliente implements IDaoCliente {

	@PersistenceContext
	private EntityManager em; 
	
	@Transactional (readOnly = true)
	@Override
	public List<Cliente> findAll() {
		try {
			List<Cliente> listaClientes = em.createQuery("FROM Cliente", Cliente.class).getResultList();
			return listaClientes;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional (readOnly = true)
	@Override
	public Cliente findById(int id) {
		try {
            Cliente cliente = em.find(Cliente.class, id);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Cliente save(Cliente cliente) {
		try {
			em.persist(cliente);
			return cliente;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public Cliente update(Cliente cliente) {
		try {
			em.merge(cliente);
			return cliente;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
