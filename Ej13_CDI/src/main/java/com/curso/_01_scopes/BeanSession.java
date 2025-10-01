package com.curso._01_scopes;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@SessionScoped
public class BeanSession implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private BeanDependent beanDependent;
	
	public BeanSession() {
		super();
		System.out.println("---BeanSession----------");
	}
	
	public String toString(){
		return super.toString()+"-"+beanDependent;
	}
	
}
