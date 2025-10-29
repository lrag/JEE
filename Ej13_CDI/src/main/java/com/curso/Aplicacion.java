package com.curso;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.curso._01_scopes.BeanApplication;

public class Aplicacion {
	
	//@EJB
	///@Inject
	private BeanApplication ba;
	
	
	public static void main(String[] args) {
	    Weld weld = new Weld();
	    WeldContainer container = weld.initialize();
	 
		System.out.println(CDI.current().select(BeanApplication.class).get());	    
	    
	    Aplicacion a = new Aplicacion();
	    a.ba = CDI.current().select(BeanApplication.class).get();
	    
	    container.shutdown();
	}	
	
}
