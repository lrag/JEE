package com.curso._06_eventos;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class ProcesadorEventos {

	public void procesarEvento(@Observes String evento){
		System.out.println("======================================");
		System.out.println("Evento recibido (String):"+evento);
		System.out.println("Thread:"+Thread.currentThread().getId());	
	}
	
	public void procesarEvento2(@Observes String evento){
		System.out.println("======================================");
		System.out.println("Evento recibido (String 2):"+evento);
		System.out.println("Thread:"+Thread.currentThread().getId());	
	}

	public void procesarEvento(@Observes Integer evento){
		System.out.println("======================================");
		System.out.println("Evento recibido (Integer):"+evento);
		System.out.println("Thread:"+Thread.currentThread().getId());
	}
	
	public void procesarEventoPedido(@Observes @QEventoPedido Pedido pedido){
		System.out.println("======================================");
		System.out.println("Evento recibido (Pedido):"+pedido.getCodigo());
		System.out.println("Thread:"+Thread.currentThread().getId());
	}
	
	public void procesarEventoPedidoImportante(@ObservesAsync @QEventoPedidoImportante Pedido pedido){
		System.out.println("======================================");
		System.out.println("Evento recibido (Pedido importante):"+pedido.getCodigo());
		System.out.println("Thread:"+Thread.currentThread().getId()+" "+Thread.currentThread().getName());
		try {
			Thread.sleep(20_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("EVENTO PEDIDO IMPORTANTE PROCESADO");
	}
	
}




