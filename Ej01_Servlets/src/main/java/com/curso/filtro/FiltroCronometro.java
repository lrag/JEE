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

@WebFilter("/*")
public class FiltroCronometro extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public FiltroCronometro() {
        super();
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest rq = (HttpServletRequest) request;

		//ANTES
		long inicio = System.currentTimeMillis();
		 
		chain.doFilter(request, response);
		
		//DESPUES
		long fin = System.currentTimeMillis();
		System.out.println("PETICIÓN PROCESADA EN "+(fin-inicio)+" MILISEGUNDOS.");
		
	}

	public void destroy() {
	}

}
