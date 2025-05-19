package com.curso.modelo.entidad;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="software_joined")
@DiscriminatorValue(value="SW")
public class Software_Joined extends Producto_Joined {

	protected String tecnologia;
	
	public Software_Joined() {
		super();
	}

	public Software_Joined(int idProducto, String nombre, String descripcion,
			String tecnologia, Integer existencias) {
		super(idProducto, nombre, descripcion, existencias);
		this.tecnologia = tecnologia;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Software [tecnologia=" + tecnologia + ", idProducto="
				+ idProducto + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

}
