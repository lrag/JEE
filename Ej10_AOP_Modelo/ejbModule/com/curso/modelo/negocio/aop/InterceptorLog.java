package com.curso.modelo.negocio.aop;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//La clase no tiene anotaciones pero ser� manejada por el contenedor
public class InterceptorLog {

	//Un interceptor puede recibir inyecciones...
	//@EJB
	//@Resource
	//@...
	
	@AroundInvoke
	public Object log(InvocationContext iCtx) throws Exception {
		
		iCtx.getMethod();     //A q�e m�todo se est� llamando
		iCtx.getParameters(); //Con que par�metros se est� invocando
		iCtx.getTarget();     //El verdadero EJB

		System.out.println("Llamada al m�todo "+iCtx.getMethod().getName()+". Hora:"+new Date());
		
		//Antes de invocar al target
		Object retorno = iCtx.proceed();
		//Despues de invocar al target
		
		return retorno;
	}
	
}
