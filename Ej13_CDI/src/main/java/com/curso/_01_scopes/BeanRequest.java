package com.curso._01_scopes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BeanRequest {

	@Inject
	private BeanDependent beanDependent;

	public BeanRequest() {
		super();
		System.out.println("---BeanRequest----------");
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("BeanRequest POSTCONSTRUCT");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("BeanRequest PREDESTROY");
	}	
	
	public String toString(){
		return super.toString()+"-"+beanDependent;
	}

}
