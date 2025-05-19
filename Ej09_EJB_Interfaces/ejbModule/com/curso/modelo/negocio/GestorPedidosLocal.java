package com.curso.modelo.negocio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GestorPedidosLocal {

    public boolean addProducto(String producto);
    public List<String> listarCesta();
    public void remove();
	
}
