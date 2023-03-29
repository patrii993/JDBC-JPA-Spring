package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tiendas", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class TiendaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtienda;
	private String nombre;
	private String direccion;
	@OneToMany(mappedBy ="tienda", cascade = CascadeType.REMOVE)
	private List<TiendaProductoVO> productos;
	
	
	
	public TiendaVO() {
		productos=new ArrayList();
	}



	/**
	 * @param idtienda
	 * @param nombre
	 * @param direccion
	 * @param tiendas
	 */
	public TiendaVO(int idtienda, String nombre, String direccion, List<TiendaProductoVO> productos) {
		super();
		this.idtienda = idtienda;
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = productos;
	}



	/**
	 * @param nombre
	 * @param direccion
	 * @param tiendas
	 */
	public TiendaVO(String nombre, String direccion, List<TiendaProductoVO> productos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = productos;
	}



	/**
	 * @return the idtienda
	 */
	public int getIdtienda() {
		return idtienda;
	}



	/**
	 * @param idtienda the idtienda to set
	 */
	public void setIdtienda(int idtienda) {
		this.idtienda = idtienda;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}



	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	/**
	 * @return the tiendas
	 */
	public List<TiendaProductoVO> getProductos() {
		return productos;
	}



	/**
	 * @param tiendas the tiendas to set
	 */
	public void setProductos(List<TiendaProductoVO> productos) {
		this.productos = productos;
	}



	@Override
	public String toString() {
		return "TiendaVO [idtienda=" + idtienda + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	

}
