package com.dawes.instituto;

import java.time.LocalDate;
import java.util.Objects;

public class ProfesorCiclo {
	private int idprofesorciclo;
	private Profesor profesor;
	private Ciclo ciclo;
	private LocalDate fecha;
	
	public ProfesorCiclo(int idprofesorciclo, Profesor profesor, Ciclo ciclo, LocalDate fecha) {
		super();
		this.idprofesorciclo = idprofesorciclo;
		this.profesor = profesor;
		this.ciclo = ciclo;
		this.fecha = fecha;
	}
	public ProfesorCiclo(Profesor profesor, Ciclo ciclo, LocalDate fecha) {
		super();
		this.profesor = profesor;
		this.ciclo = ciclo;
		this.fecha = fecha;
	}
	public int getIdprofesorciclo() {
		return idprofesorciclo;
	}
	public void setIdprofesorciclo(int idprofesorciclo) {
		this.idprofesorciclo = idprofesorciclo;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public Ciclo getCiclo() {
		return ciclo;
	}
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciclo, fecha, idprofesorciclo, profesor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfesorCiclo other = (ProfesorCiclo) obj;
		return Objects.equals(ciclo, other.ciclo) && Objects.equals(fecha, other.fecha)
				&& idprofesorciclo == other.idprofesorciclo && Objects.equals(profesor, other.profesor);
	}
	@Override
	public String toString() {
		return "ProfesorCiclo [idprofesorciclo=" + idprofesorciclo + ", profesor=" + profesor + ", ciclo=" + ciclo
				+ ", fecha=" + fecha + "]";
	}
	
	


}
