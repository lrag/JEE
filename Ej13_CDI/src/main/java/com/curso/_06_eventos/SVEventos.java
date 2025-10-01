package com.curso._06_eventos;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVEventos")
public class SVEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private Event<String> eventoString;
	
	@Inject
	private Event<Integer> eventoInteger;
	
	@Inject
	@QEventoPedido
	private Event<Pedido> eventoPedido;
		
	@Inject
	@QEventoPedidoImportante
	private Event<Pedido> eventoPedidoImportante;
	
    public SVEventos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("======================================");
		System.out.println("Thread:"+Thread.currentThread().getId()+" "+Thread.currentThread().getName());
		eventoString.fire("Evento!");
		eventoInteger.fire(42);
		eventoPedido.fire(new Pedido("PEDIDO"));
		eventoPedidoImportante.fireAsync(new Pedido("PEDIDO IMPORTANTE"));
		
		response.getWriter().println("<h1>Peticion procesada</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
