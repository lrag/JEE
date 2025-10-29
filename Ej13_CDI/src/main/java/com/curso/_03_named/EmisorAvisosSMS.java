package com.curso._03_named;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("emisorAvisosSMS")
public class EmisorAvisosSMS implements EmisorAvisos{

	@Override
	public void emitir(String aviso) {
		System.out.println("Emitiendo "+aviso+" por SMS");		
	}

}
