package com.curso.modelo.negocio.aop;

import java.io.BufferedWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//La clase no tiene anotaciones pero ser� manejada por el contenedor
public class InterceptorLog {

	//Un interceptor puede recibir inyecciones...
	//@EJB
	//@Resource
	//@...
	
	private BufferedWriter bw;
	
	public InterceptorLog() {
		//Como no creamos la instancia mejor no tocar el constructor
		//FileWriterfw = new FileWriter("log.txt");
		//BufferedWriter bw = new BufferedWriter(fw);
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("INICIALIZANDO INTERCEPTOR_LOG");
		//FileWriterfw = new FileWriter("log.txt");
		//BufferedWriter bw = new BufferedWriter(fw);
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("FINALIZANDO INTERCEPTOR_LOG");
		//bw.flush();
		//bw.close();
	}
		
	@AroundInvoke
	public Object log(InvocationContext iCtx) throws Exception {
		
		iCtx.getMethod();     //A qúe método se está llamando
		iCtx.getParameters(); //Con que parámetros se está invocando
		iCtx.getTarget();     //El verdadero EJB

		//bw.write("bla bla blá");
		System.out.println("INTERCEPTOR_LOG: Llamada al método "+iCtx.getMethod().getName()+". Hora:"+new Date()+"---"+iCtx.getTarget());
		//cerrarfichero
		
		//Antes de invocar al target
		Object retorno = iCtx.proceed();
		//Despues de invocar al target
		
		return retorno;
	}
	
}
