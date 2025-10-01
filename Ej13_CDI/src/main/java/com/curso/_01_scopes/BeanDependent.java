package com.curso._01_scopes;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

@Dependent //Scope por defecto
public class BeanDependent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public BeanDependent() {
		super();
		System.out.println("---BeanDependent--------");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("---Destroy:"+this);
	}
	
}
