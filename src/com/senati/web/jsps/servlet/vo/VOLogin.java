package com.senati.web.jsps.servlet.vo;

import java.io.Serializable;

public class VOLogin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1134118448805413458L;
	private String usuario;
	private String nombre;
	private Integer edad;
	private String clave;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
}
