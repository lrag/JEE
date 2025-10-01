package com.curso._04_qualifier;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@QEmisorAvisosCorreoE
public class EmisorAvisosCorreoE implements EmisorAvisos{

	@Override
	public void emitir(String aviso) {
		System.out.println("Emitiendo "+aviso+" por CorreoE");		
	}

}
