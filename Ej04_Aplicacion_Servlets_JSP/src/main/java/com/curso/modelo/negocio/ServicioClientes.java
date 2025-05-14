package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;
import com.curso.modelo.persistencia.FactoriaClienteDao;

public class ServicioClientes {

	private ClienteDao clienteDao = FactoriaClienteDao.getClienteDao();
	
	public void insertar(Cliente cliente){
		//LN para insertar el cliente
		//...
		clienteDao.insertar(cliente);		
	}
	
	public void modificar(Cliente cliente){
		//LN
		//...
		clienteDao.modificar(cliente);		
	}
	
	public void borrar(Cliente cliente){
		//LN
		//...
		clienteDao.borrar(cliente);		
	}
	
	public Cliente buscar(int id){
		return clienteDao.buscar(id);		
	}
	
	public List<Cliente> listar(int primero, int cantidad){
		return clienteDao.listar(primero, cantidad);		
	}
	
}
