 package com.curso._06_eventos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, 
		 ElementType.FIELD, 
		 ElementType.PARAMETER, 
		 ElementType.TYPE})
public @interface QEventoPedidoImportante {

}
