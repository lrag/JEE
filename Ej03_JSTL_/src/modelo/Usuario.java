package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private int idUsuario;
	private String nombre;
	private String login;
	private String pw;
	private String idioma;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String nombre, String login, String pw,
			String idioma) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.login = login;
		this.pw = pw;
		this.idioma = idioma;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", idioma=" + idioma
				+ ", login=" + login + ", nombre=" + nombre + ", pw=" + pw
				+ "]";
	}

}
