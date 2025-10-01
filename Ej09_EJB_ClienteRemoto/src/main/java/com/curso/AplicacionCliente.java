package com.curso;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.curso.modelo.negocio.GestorPedidosRemoto;


public class AplicacionCliente {

	public static void main(String[] args) throws Exception {
		
		/*
		
		java:global/Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto
		java:app/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto
		java:module/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto
		java:jboss/exported/Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto
		ejb:Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto?stateful
		*/
		
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");		
		
		InitialContext ic = new InitialContext(jndiProperties);		
		System.out.println(ic);
		
		GestorPedidosRemoto gp = (GestorPedidosRemoto) ic.lookup("ejb:Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidosRemoto?stateful");
		
		gp.addProducto("EJB P1");
		gp.addProducto("P2");
		gp.addProducto("EJB P3");
		gp.addProducto("P4");
		gp.addProducto("EJB P5");
		
		List<String> cesta = gp.listarCesta();
		for(String p: cesta){
			System.out.println(p);
		}
		
		
	}
	
}
