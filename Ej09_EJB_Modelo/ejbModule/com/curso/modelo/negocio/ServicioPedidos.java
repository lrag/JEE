package com.curso.modelo.negocio;

import java.io.Serializable;
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
import javax.ejb.Stateful;

@Stateful
//@LocalBean
//Los EJB de sesión con estado deben ser serializables
public class ServicioPedidos implements ServicioPedidosLocal, ServicioPedidosRemoto, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ValidadorProductos validador;
	
	//private transient Socket sk;
	
	//				    //
	//Este es el estado://
	//					//
	private List<String> cesta;
	
    public ServicioPedidos() {
    	//Esto dará SIEMPRE null pointer exception
    	//validador.validar("XXX");
    }

    /*****************/
    /* CICLO DE VIDA */
    /*****************/
    
    //Ciclo de vida de todos los tipos de EJBs (sesión y mdb)
    
    @PostConstruct
    public void inicializar() {
    	System.out.println("@PostConstruct de GestorPedidos");
    	cesta = new ArrayList<>();
    	//abrir el socket
    }
    
    @PreDestroy
    public void finalizar() {
    	//Codigo para liberar recursos que no pertenezcan a la JVM
    	System.out.println("@Predestroy de GestorPedidos");
    	//cerrar el socket
    }
    
    //
    //Ciclo de vida específico para los ejb de sesion con estado
    //
    private transient Socket sk; //En el post construct se inicializar�a este socket
    
    @PrePassivate
    public void pasivate() {
    	//cerrar el socket
    }
    
    @PostActivate
    public void activate() {
    	//Abrir otra vez el socket
    }
    
    @Remove
    //Este método debe estar publicado en las interfaces para que los clientes puedan invocarlo
    public void remove() {
    	System.out.println("Llamadita al remove");
    }
    
    
    //                   //
    // LOGICA DE NEGOCIO // 
    //                   //
    
    public boolean addProducto(String producto) {
    	//LN    	
    	if(!validador.validar(producto)) {
    		System.out.println("Producto rechazado "+producto);
    		return false;
    	}
    	System.out.println("Añadiendo el producto "+producto);
    	cesta.add(producto);
    	return true;
    }

    public List<String> listarCesta(){
    	return cesta;
    }
    
    public void comprar() {
    	System.out.println("Comprando la cesta: "+cesta.stream().collect(Collectors.joining(", ")));
    }
    
}







