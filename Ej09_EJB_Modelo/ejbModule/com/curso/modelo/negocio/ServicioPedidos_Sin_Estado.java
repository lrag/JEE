package com.curso.modelo.negocio;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ServicioPedidos_Sin_Estado {

	@EJB
	private ValidadorProductos validador;
	
    public ServicioPedidos_Sin_Estado() {
    }
    
    public boolean validar(String producto) {
    	return validador.validar(producto);
    }
    
    public void comprar(List<String> cesta) {
    	//VALIDACION
    	System.out.println("Comprando la cesta: "+cesta.stream().collect(Collectors.joining(", ")));
    }
    
}







