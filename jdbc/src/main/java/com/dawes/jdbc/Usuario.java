package com.dawes.jdbc;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {
	private int idusuario;
	private String nombre;
	private int edad;
	private LocalDate fecha;
	
	
	/**
	 * Constructor
	 * @param idusuario
	 * @param nombre
	 * @param edad
	 */
	public Usuario(String nombre, int edad, LocalDate fecha) {
		super();
		
		this.nombre = nombre;
		this.edad = edad;
		this.fecha= fecha;
	}
		
	/**
	 * @param idusuario
	 * @param nombre
	 * @param edad
	 */
	public Usuario(int idusuario, String nombre, int edad, LocalDate fecha) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.edad = edad;
		this.fecha= fecha;
	}



	/**
	 * Constructor
	 * Sin parametros, por defecto
	 */
	public Usuario() {
		super();
	}


	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}
	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idusuario, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idusuario == other.idusuario && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre + ", edad=" + edad + ", fecha=" + fecha + "]";
	}
	

}