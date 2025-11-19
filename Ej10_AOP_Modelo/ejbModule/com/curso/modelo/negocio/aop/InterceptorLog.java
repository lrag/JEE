package com.curso.modelo.negocio.aop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

//POJO
//La clase no tiene anotaciones pero será manejada por el contenedor cuando vea el @AroundInvoke
//Tiene que tener constructor por defecto
//Será un singleton
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
	public void inicializar() throws IOException {
		System.out.println("INICIALIZANDO INTERCEPTOR_LOG");
		FileWriter fw = new FileWriter("D:/log.txt");
		bw = new BufferedWriter(fw);
	}
	
	@PreDestroy
	public void preDestroy() throws IOException {
		System.out.println("FINALIZANDO INTERCEPTOR_LOG");
		bw.flush();
		bw.close();
	}
		
	//Solo puede haber un método con around invoke dentro de un interceptor
	@AroundInvoke
	public Object log(InvocationContext iCtx) throws Exception {
		
		iCtx.getMethod();     //A qúe método se está llamando
		iCtx.getParameters(); //Con que parámetros se está invocando
		iCtx.getTarget();     //El verdadero EJB
		
		bw.write("INTERCEPTOR_LOG: Llamada al método "+iCtx.getMethod().getName()+". Hora:"+new Date()+"---"+iCtx.getTarget());
		System.out.println("INTERCEPTOR_LOG: Llamada al método "+iCtx.getMethod().getName()+". Hora:"+new Date()+"---"+iCtx.getTarget());
		
		//Antes de invocar al target
		Object retorno = iCtx.proceed();
		//Despues de invocar al target
		
		return retorno;
	}
	
}
