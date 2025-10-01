package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Incidencia;

public class ServicioIncidencias {

	//private IncidenciaRepo incidenciaRepo;

	private static ServicioIncidencias instancia = new ServicioIncidencias();
	
	public static ServicioIncidencias getInstancia() {
		return instancia;
	}
	
	private ServicioIncidencias() {
		super();
	}
	
	
	public List<Incidencia> listar(){
		return List.of(
				new Incidencia(1, "Parpadea un fluorescente", "Antúnez", "Pendiente"),
				new Incidencia(2, "No funciona el ascensor", "Sr. Smith", "En progreso"),
				new Incidencia(3, "No abre una ventana", "Antúnez", "Buscando la ventana"),
				new Incidencia(4, "El timbre sólo hace DING", "Sr. Smith", "Pendiente"),
				new Incidencia(5, "Un grifo gotea", "Sin asignar", "Pendiente"),
				new Incidencia(6, "Cuando se da la luz en el pasillo suena DONG", "Sr. Smith", "Pendiente")
			);
	}

	
}
