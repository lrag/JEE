package com.curso.oyente;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class OyenteServletContext implements ServletContextListener {

    public OyenteServletContext() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("CONTEXTO INICIALIZADO");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("EL CONTEXTO VA A DESTRUIRSE");
    }
	
}

