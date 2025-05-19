package com.curso.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="producto_joined") //Puede tener @Table
@Inheritance(strategy=InheritanceType.JOINED)
//Tambien puede tener discriminator column (si no se la inventa)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING, length=2)
@DiscriminatorValue(value="PR")
public class Producto_Joined { //Tambien puede ser abstracta (deber�a ser abstracta)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productosSeq")
	//@SequenceGenerator(name="productosSeq", sequenceName="productos_seq", initialValue=0, allocationSize=1)
	@Column(name="id_producto")
	protected int idProducto;
	protected String nombre;
	protected String descripcion;
	protected Integer existencias;

	public Producto_Joined() {
		super();
	}

	public Producto_Joined(int idProducto, String nombre, String descripcion, Integer existencias) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencias = existencias;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	@Override
	public String toString() {
		return "Producto_Joined [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", existencias=" + existencias + "]";
	}

}
