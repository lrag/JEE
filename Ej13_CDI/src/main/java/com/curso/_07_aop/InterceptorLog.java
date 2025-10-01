package com.curso._07_aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

//
// Los interceptores se registran en el beans.xml
//

@Log
@Interceptor
public class InterceptorLog {

	@AroundInvoke
	public Object log(InvocationContext iCtx) throws Exception{
		
		System.out.println("Llamada al metodo "+iCtx.getMethod().getName()+" de "+iCtx.getTarget());
		Object obj = iCtx.proceed();
		
		return obj;		
	}
	
}
