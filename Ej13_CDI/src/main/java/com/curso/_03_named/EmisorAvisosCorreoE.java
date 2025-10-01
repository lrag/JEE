package com.curso._03_named;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@ApplicationScoped
@Named("emisorAvisosCorreoE")
public class EmisorAvisosCorreoE implements EmisorAvisos{

	@Override
	public void emitir(String aviso) {
		System.out.println("Emitiendo "+aviso+" por CorreoE");		
	}

}
