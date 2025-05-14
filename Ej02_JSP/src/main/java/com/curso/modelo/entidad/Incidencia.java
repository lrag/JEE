package com.curso.modelo.entidad;

import java.io.Serializable;

public class Incidencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idIncidencia;
	private String empleado;
	private String descripcion;
	private String estado;

	public Incidencia() {
		super();
	}

	public Incidencia(Integer idIncidencia, String empleado, String descripcion, String estado) {
		super();
		this.idIncidencia = idIncidencia;
		this.empleado = empleado;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(Integer idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Incidencia [idIncidencia=" + idIncidencia + ", empleado=" + empleado + ", descripcion=" + descripcion
				+ ", estado=" + estado + "]";
	}

}
