package com.curso.modelo.negocio;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ServicioPedidosRemoto {

    boolean addProducto(String producto);
    List<String> listarCesta();
    void comprar();
    void remove();
	
}
