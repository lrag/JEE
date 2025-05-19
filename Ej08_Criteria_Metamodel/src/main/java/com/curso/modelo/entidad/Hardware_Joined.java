package com.curso.modelo.entidad;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Hardware_joined") //Puede tener table
@DiscriminatorValue(value="HW")
//Puede tener un valor para la discriminator column
public class Hardware_Joined extends Producto_Joined {
	//No tiene @Id
	protected double peso;

	public Hardware_Joined() {
		super();
	}

	public Hardware_Joined(int idProducto, String nombre, String descripcion,
			double peso, Integer existencias) {
		super(idProducto, nombre, descripcion, existencias);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Hardware [peso=" + peso + ", idProducto=" + idProducto
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
