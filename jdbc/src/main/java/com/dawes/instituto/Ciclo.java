package com.dawes.instituto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ciclo {
	
	//atributos
	private int idciclo;
	private String dencorta;
	private String denlarga;
	private Set<ProfesorCiclo> profesores;
	
	
	//constructores
	/**
	 * @param idciclo
	 * @param dencorta
	 * @param denlarga
	 */
	public Ciclo(int idciclo, String dencorta, String denlarga) {
		super();
		this.idciclo = idciclo;
		this.dencorta = dencorta;
		this.denlarga = denlarga;
		this.profesores = new HashSet();
	}

	
	/**
	 * @return the profesores
	 */
	public Set<ProfesorCiclo> getProfesores() {
		return profesores;
	}


	/**
	 * @param profesores the profesores to set
	 */
	public void setProfesores(Set<ProfesorCiclo> profesores) {
		this.profesores = profesores;
	}


	/**
	 * 
	 */
	public Ciclo() {
		super();
	}

	/**
	 * @param dencorta
	 * @param denlarga
	 */
	public Ciclo(String dencorta, String denlarga) {
		super();
		this.dencorta = dencorta;
		this.denlarga = denlarga;
		this.profesores = new HashSet();
	}
	
	//Geters and seters
	/**
	 * @return the idciclo
	 */
	public int getIdciclo() {
		return idciclo;
	}

	/**
	 * @param idciclo the idciclo to set
	 */
	public void setIdciclo(int idciclo) {
		this.idciclo = idciclo;
	}

	/**
	 * @return the dencorta
	 */
	public String getDencorta() {
		return dencorta;
	}

	/**
	 * @param dencorta the dencorta to set
	 */
	public void setDencorta(String dencorta) {
		this.dencorta = dencorta;
	}

	/**
	 * @return the denlarga
	 */
	public String getDenlarga() {
		return denlarga;
	}

	/**
	 * @param denlarga the denlarga to set
	 */
	public void setDenlarga(String denlarga) {
		this.denlarga = denlarga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dencorta, denlarga, idciclo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciclo other = (Ciclo) obj;
		return Objects.equals(dencorta, other.dencorta) && Objects.equals(denlarga, other.denlarga)
				&& idciclo == other.idciclo;
	}

	@Override
	public String toString() {
		return "Ciclo [idciclo=" + idciclo + ", dencorta=" + dencorta + ", denlarga=" + denlarga + "]";
	}
	
	
	
	
}
