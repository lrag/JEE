package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Clase de acceso público
//Con constructor por defecto
//Seriarizable
//Son clases manejadas al 100%
//El contenedor de servlets creará una única instancia -> SINGLETON
//
//Ciclo de vida de un servlet:
//El contenedor invoca el constructor por defecto
//La instancia se registra como servlet
//El contenedor invoca el método init
public class _01_SVEjemplo implements Servlet {
	
	private static final long serialVersionUID = 1L;
	
	private transient ServletConfig svCfg;
	private String dato;
	
	public _01_SVEjemplo() {
		super();
		//Cuando se está ejecutando el constructor la instancia todavía no es un servlet
		System.out.println("=================================================");
		System.out.println("Instanciando SVEjemplo");
	}

	@Override
	public void init(ServletConfig svCfg) throws ServletException {
		System.out.println("=================================================");
		System.out.println("Inicializando SVEjemplo");
		dato = svCfg.getInitParameter("dato");		
		this.svCfg = svCfg;
	}

	@Override
	public ServletConfig getServletConfig() {
		return svCfg;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//ESCRIBIR EN EL LOG
		
		System.out.println("=================================================");
		System.out.println(this);		
		System.out.println("dato: "+dato);
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("Petición recibida: "+request.getMethod()+" "+request.getRequestURL()+"<br/>");		
		out.write("</body></html>");
		
	}

	@Override
	public String getServletInfo() {
		return "Soy el servlet de ejemplo";
	}

	@Override
	public void destroy() {
		System.out.println("=================================================");
		System.out.println("SVEjemplo: Destroy");
	}

}
