package com.curso._05_produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FactoriaFormateador {

	//Esto lo habríamos leído de un fichero de configuración
	private String tipo = "Excel";
	
	/*
	@Produces
	@QFormateador
	@RequestScoped
	public Formateador getFormateador(){
		switch(tipo){
			//Cuidado que aqui 'otraBean' de FormateadorWord queda a null
			case "Word"  : return new FormateadorWord();
			case "PDF"   : return new FormateadorPDF();
			case "Excel" : return new FormateadorExcel("DATO"); 
			default : return null;		
		}
	}	
	*/

	/*
	@Produces
	@QFormateador
	@RequestScoped
	public Formateador getFormateador(OtraBean otraBean){
		System.out.println("OtraBean:"+otraBean);
		switch(tipo){
			case "Word"  : return new FormateadorWord(otraBean);
			case "PDF"   : return new FormateadorPDF();
			case "Excel" : return new FormateadorExcel(otraBean, "DATO"); 
			default : return null;		
		}		
	}
	*/
	
	
	@Produces
	@QFormateador
	@RequestScoped
	//Si optamos por esta opcion tambien podríamos declarar en la clase
	//@Inject private FormateadorPDF formateadorPDF;
	//@Inject private FormateadorWord formateadorWord;
	public Formateador getFormateador(FormateadorPDF formateadorPDF,
								      FormateadorWord formateadorWord,
								      FormateadorExcel formateadorExcel){
		switch(tipo){
			case "Word"  : return formateadorWord;
			case "PDF"   : return formateadorPDF;
			case "Excel" : return formateadorExcel; //Este no tiene 'dato'
			default : return null;		
		}		
	}	
	

}
