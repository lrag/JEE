package com.curso.modelo.negocio.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorCronometro {

	@AroundInvoke
	public Object cronometrar(InvocationContext iCtx) throws Exception {
		
		
		long inicio = System.currentTimeMillis();

		Object retorno = iCtx.proceed();
		
		long fin = System.currentTimeMillis();
		System.out.println("Llamada al m�todo "+iCtx.getMethod().getName()+" procesada en "+(fin-inicio)+" milisegundos.");
		return retorno;	
		
	}
	
}
