package com.curso._07_aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Cronometro
@Interceptor
public class InterceptorCronometro {

	@AroundInvoke
	public Object cronometro(InvocationContext iCtx) throws Exception{
		
		long inicio = System.currentTimeMillis();
		Object obj = iCtx.proceed();
		long fin = System.currentTimeMillis();
		
		System.out.println("Llamada al metodo "+iCtx.getMethod().getName()+" de "+iCtx.getTarget()+" procesada en "+(fin-inicio)+" milisegundos.");
		
		return obj;		
	}
	
}
