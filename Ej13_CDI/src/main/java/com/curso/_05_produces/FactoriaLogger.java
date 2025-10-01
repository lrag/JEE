package com.curso._05_produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FactoriaLogger {

	@Produces
	@QLogger
	@ApplicationScoped
	public Logger getLogger(){
		return new Logger("d:/log.txt");
	}
	
	@Produces
	@QLoggerError
	@ApplicationScoped
	public Logger getLoggerError(){
		return new Logger("d:/logError.txt");
	}	

}
