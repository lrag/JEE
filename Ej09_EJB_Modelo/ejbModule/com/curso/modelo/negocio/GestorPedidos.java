package com.curso.modelo.negocio;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class GestorPedidos implements GestorPedidosLocal {

	@EJB
	private ValidadorProductos validador;
	
	private List<String> cesta;
	
    public GestorPedidos() {
    	//Esto dará SIEMPRE null pointer exception
    	//validador.validar("XXX");
    }

    /*****************/
    /* CICLO DE VIDA */
    /*****************/
    
    //Ciclo de vida de todos los tipos de EJBs (sesión y mdb)
    
    @PostConstruct
    public void inicializar() {
    	System.out.println("@PostConstruct");
    	cesta = new ArrayList<>();
    }
    
    @PreDestroy
    public void finalizar() {
    	//Codigo para liberar recursos que no pertenezcan a la JVM
    	System.out.println("@Predestroy");
    }
    
    //Ciclo de vida espec�fico para los ejb de sesi�n con estado
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
    //Este método debe estar publicado en las interfaces
    public void remove() {
    	System.out.println("Llamadita al remove");
    }
    
    
    public boolean addProducto(String producto) {
    	if(!validador.validar(producto)) {
    		System.out.println("Producto rechazado "+producto);
    		return false;
    	}
    	System.out.println("A�adiendo el producto "+producto);
    	cesta.add(producto);
    	return true;
    }

    public List<String> listarCesta(){
    	return cesta;
    }
    
}







