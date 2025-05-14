package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Usuario;

public class ServicioUsuarios {

	public Usuario buscarPorLogin(String login, String password) {		
		if(login.equals("harry") && password.equals("callahan")) {
			return new Usuario(1, "harry callahan", "harry", "callahan", "es");
		}
		if(login.equals("bud") && password.equals("spencer")) {
			return new Usuario(1, "bud spencer", "bud", "spencer", "en");
		}
		return null;		
	}
	
}
