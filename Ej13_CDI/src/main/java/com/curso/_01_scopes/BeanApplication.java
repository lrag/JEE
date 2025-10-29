package com.curso._01_scopes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BeanApplication {

	@Inject
	private BeanDependent beanDependent;

	@Inject 
	private BeanRequest beanRequest;
	
	public BeanApplication() {
		super();
		System.out.println("---BeanApplication------");
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("POST CONSTRUCT DE BeanApplication");
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("PRE CONSTRUCT DE BeanApplication");
	}	

	public String toString(){
		return super.toString()+"-"+beanDependent+"-BRq-"+beanRequest;
	}
	
}
