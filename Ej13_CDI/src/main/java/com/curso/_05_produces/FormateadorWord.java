package com.curso._05_produces;

import javax.inject.Inject;

public class FormateadorWord implements Formateador{

	@Inject
	private OtraBean otraBean;
	
	public FormateadorWord() {
		super();
	}

	public FormateadorWord(OtraBean otraBean) {
		super();
		this.otraBean = otraBean;
	}

	public OtraBean getOtraBean() {
		return otraBean;
	}

	public void setOtraBean(OtraBean otraBean) {
		this.otraBean = otraBean;
	}
	
	@Override
	public void formatear(String texto) {
		System.out.println("Formateando "+texto+" en Word. OtraBean:"+otraBean);		
	}

}
