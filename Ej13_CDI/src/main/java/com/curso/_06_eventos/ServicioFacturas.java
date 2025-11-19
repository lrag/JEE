package com.curso._06_eventos;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class ServicioFacturas {
	
	public Factura emitirFactura(Pedido pedido) {
		System.out.println("Emititiendo una factura con el pedido: "+pedido);
		return new Factura();
	}	

	//Si no añadimos el qualifier se reciben todos los eventos del tipo Pedido
	public void procesarEventoPedido(@Observes /*@QEventoPedido*/ Pedido pedido){
		System.out.println("======================================");
		System.out.println("Evento recibido (Pedido):"+pedido.getCodigo());
		System.out.println("Thread:"+Thread.currentThread().getId());
		emitirFactura(pedido);
	}
	
}




