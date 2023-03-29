package com.dawes.instituto;

public class Listado {
	private String dencorta;
	private String nombre;
	/**
	 * @param dencorta
	 * @param nombre
	 */
	public Listado(String dencorta, String nombre) {
		super();
		this.dencorta = dencorta;
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Listado [dencorta=" + dencorta + ", nombre=" + nombre + "]";
	}
	
	

}
