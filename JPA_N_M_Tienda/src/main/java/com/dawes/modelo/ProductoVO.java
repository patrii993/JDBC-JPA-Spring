package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;	

@Entity
@Table(name = "productos")
public class ProductoVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	private String fabricante;
	private String referencia;
	private float precio;
	@OneToMany(mappedBy = "producto")
	private List<TiendaProductoVO> tiendas;
	
	
	public ProductoVO() {
		tiendas=new ArrayList();
		
	}


	/**
	 * @param idproductos
	 * @param fabricante
	 * @param referencia
	 * @param precio
	 * @param productos
	 */
	public ProductoVO(int idproducto, String fabricante, String referencia, float precio,
			List<TiendaProductoVO> tiendas) {
		super();
		this.idproducto = idproducto;
		this.fabricante = fabricante;
		this.referencia = referencia;
		this.precio = precio;
		this.tiendas = tiendas;
	}


	/**
	 * @param fabricante
	 * @param referencia
	 * @param precio
	 * @param productos
	 */
	public ProductoVO(String fabricante, String referencia, float precio, List<TiendaProductoVO> tiendas) {
		super();
		this.fabricante = fabricante;
		this.referencia = referencia;
		this.precio = precio;
		this.tiendas = tiendas;
	}


	/**
	 * @return the idproductos
	 */
	public int getIdproducto() {
		return idproducto;
	}


	/**
	 * @param idproductos the idproductos to set
	 */
	public void setIdproductos(int idproducto) {
		this.idproducto = idproducto;
	}


	/**
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}


	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}


	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	/**
	 * @return the productos
	 */
	public List<TiendaProductoVO> getTiendas() {
		return tiendas;
	}


	/**
	 * @param productos the productos to set
	 */
	public void setTiendas(List<TiendaProductoVO> tiendas) {
		this.tiendas = tiendas;
	}


	@Override
	public String toString() {
		return "ProductoVO [idproducto=" + idproducto + ", fabricante=" + fabricante + ", referencia=" + referencia
				+ ", precio=" + precio  + "]";
	}
	
	

}
