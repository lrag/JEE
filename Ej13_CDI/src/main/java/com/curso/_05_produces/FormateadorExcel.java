package com.curso._05_produces;

import javax.inject.Inject;

//@ApplicationScoped
public class FormateadorExcel implements Formateador{

	@Inject
	private OtraBean otraBean;
	
	private String dato;
	
	public FormateadorExcel() {
		super();
	}
	
	public FormateadorExcel(String dato) {
		super();
		this.dato = dato;
	}

	public FormateadorExcel(OtraBean otraBean, String dato) {
		super();
		this.otraBean = otraBean;
		this.dato = dato;
	}

	public FormateadorExcel(OtraBean otraBean) {
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
		System.out.println("Formateando "+texto+" en Excel. OtraBean:"+otraBean);		
	}

}
