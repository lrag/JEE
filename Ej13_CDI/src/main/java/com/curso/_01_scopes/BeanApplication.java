package com.curso._01_scopes;

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

	public String toString(){
		return super.toString()+"-"+beanDependent+"-BRq-"+beanRequest;
	}
	
}
