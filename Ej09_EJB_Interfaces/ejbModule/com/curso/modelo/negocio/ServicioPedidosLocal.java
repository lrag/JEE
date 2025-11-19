package com.curso.modelo.negocio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ServicioPedidosLocal {

    boolean addProducto(String producto);
    List<String> listarCesta();
    void comprar();
    void remove();
	
}
