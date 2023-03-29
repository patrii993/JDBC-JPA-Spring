package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tiendaproducto" )
public class TiendaProductoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtp;
	@ManyToOne
	private TiendaVO tienda;
	@ManyToOne
	private ProductoVO producto;
	private int stock;
	
	
	public TiendaProductoVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idtp
	 * @param tienda
	 * @param producto
	 * @param stock
	 */
	public TiendaProductoVO(int idtp, TiendaVO tienda, ProductoVO producto, int stock) {
	
		this.idtp = idtp;
		this.tienda = tienda;
		this.producto = producto;
		this.stock = stock;
	}
	/**
	 * @param tienda
	 * @param producto
	 * @param stock
	 */
	public TiendaProductoVO(TiendaVO tienda, ProductoVO producto, int stock) {
		super();
		this.tienda = tienda;
		this.producto = producto;
		this.stock = stock;
	}
	/**
	 * @return the idtp
	 */
	public int getIdtp() {
		return idtp;
	}
	/**
	 * @param idtp the idtp to set
	 */
	public void setIdtp(int idtp) {
		this.idtp = idtp;
	}
	/**
	 * @return the tienda
	 */
	public TiendaVO getTienda() {
		return tienda;
	}
	/**
	 * @param tienda the tienda to set
	 */
	public void setTienda(TiendaVO tienda) {
		this.tienda = tienda;
	}
	/**
	 * @return the producto
	 */
	public ProductoVO getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoVO producto) {
		this.producto = producto;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "TiendaProductoVO [idtp=" + idtp + ", tienda=" + tienda + ", producto=" + producto + ", stock=" + stock
				+ "]";
	}
	
	

}
