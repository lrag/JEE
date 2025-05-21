package com.curso.modelo.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class GestorPedidos {

    public GestorPedidos() {
    }

    public void procesarPedido(String pedido){
    	System.out.println("Procesando el pedido:"+pedido);
    }
    
}
