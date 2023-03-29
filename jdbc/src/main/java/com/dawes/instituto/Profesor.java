package com.dawes.instituto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Profesor {
	
	//atributos
	private int idprofesor;
	private String nombre;
	private String nif;
	private LocalDate fecha;
	private Set<ProfesorCiclo> ciclos;
	
	
	//constructores
	/**
	 * @param idprofesor
	 * @param nombre
	 * @param nif
	 * @param fecha
	 */
	public Profesor(int idprofesor, String nombre, String nif, LocalDate fecha) {
		super();
		this.idprofesor = idprofesor;
		this.nombre = nombre;
		this.nif = nif;
		this.fecha = fecha;
		this.ciclos=new HashSet();
	}


	/**
	 * @param nombre
	 * @param nif
	 * @param fecha
	 */
	public Profesor(String nombre, String nif, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.nif = nif;
		this.fecha = fecha;
		this.ciclos=new HashSet();
	}


	/**
	 * Sin parametros
	 */
	public Profesor() {
		super();
	}
	
	//GETTERS AND SETTERS
	
	/**
	 * @return the ciclos
	 */
	public Set<ProfesorCiclo> getCiclos() {
		return ciclos;
	}


	/**
	 * @param ciclos the ciclos to set
	 */
	public void setCiclos(Set<ProfesorCiclo> ciclos) {
		this.ciclos = ciclos;
	}

	
	/**
	 * @return the idprofesor
	 */
	public int getIdprofesor() {
		return idprofesor;
	}


	/**
	 * @param idprofesor the idprofesor to set
	 */
	public void setIdprofesor(int idprofesor) {
		this.idprofesor = idprofesor;
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
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}


	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
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


	@Override
	public int hashCode() {
		return Objects.hash(idprofesor, nif);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return idprofesor == other.idprofesor && Objects.equals(nif, other.nif);
	}


	@Override
	public String toString() {
		return "Profesor [idprofesor=" + idprofesor + ", nombre=" + nombre + ", nif=" + nif + ", fecha=" + fecha + "]";
	}
	
	
	
	
	
	
}
