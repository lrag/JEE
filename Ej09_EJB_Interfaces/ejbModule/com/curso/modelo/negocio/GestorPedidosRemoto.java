package com.curso.modelo.negocio;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GestorPedidosRemoto {

    public boolean addProducto(String producto);
    public List<String> listarCesta();
    public void remove();
	
}
