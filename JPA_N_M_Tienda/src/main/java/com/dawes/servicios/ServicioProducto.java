package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ProductoVO;

public interface ServicioProducto {

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#insertar(com.dawes.modelo.ProductoVO)
	 */
	int insertar(ProductoVO producto);

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#modificar(com.dawes.modelo.ProductoVO)
	 */
	int modificar(ProductoVO producto);

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#eliminar(com.dawes.modelo.ProductoVO)
	 */
	int eliminar(ProductoVO producto);

	/**
	 * @param id
	 * @return
	 * @see com.dawes.dao.ProductoDAO#findById(int)
	 */
	Optional<ProductoVO> findById(int id);

	/**
	 * @return
	 * @see com.dawes.dao.ProductoDAO#findAll()
	 */
	Optional<List<ProductoVO>> findAll();

}