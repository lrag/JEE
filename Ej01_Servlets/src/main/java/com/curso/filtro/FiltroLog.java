package com.curso.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/controladores/*")
//Clase de acceso público
//Con constructor por defecto
//Seriarizable
//Son clases manejadas al 100%
//El contenedor de servlets creará una única instancia -> SINGLETON
public class FiltroLog extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public FiltroLog() {
        super();
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ANTES");
		
		
		HttpServletRequest rq = (HttpServletRequest) request;
		System.out.println("FILTRO LOG: "+rq.getMethod()+" "+rq.getRequestURI());
		
		chain.doFilter(request, response);
		
		
		System.out.println("DESPUES");
	}

	public void destroy() {
	}

}
