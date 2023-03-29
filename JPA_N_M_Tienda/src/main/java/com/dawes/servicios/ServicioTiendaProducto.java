package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.TiendaProductoVO;

public interface ServicioTiendaProducto {

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#insertar(com.dawes.modelo.TiendaProductoVO)
	 */
	int insertar(TiendaProductoVO tp);

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#modificar(com.dawes.modelo.TiendaProductoVO)
	 */
	int modificar(TiendaProductoVO tp);

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#elminar(com.dawes.modelo.TiendaProductoVO)
	 */
	int elminar(TiendaProductoVO tp);

	/**
	 * @param producto
	 * @param tienda
	 * @param stock
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#findByTiendaProductoStock(com.dawes.modelo.ProductoVO, com.dawes.modelo.TiendaVO, java.lang.Boolean)
	 */
	Optional<List<TiendaProductoVO>> findByTiendaProductoStock(ProductoVO producto);

}