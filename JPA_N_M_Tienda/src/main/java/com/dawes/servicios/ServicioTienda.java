package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.TiendaVO;

public interface ServicioTienda {

	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#insertar(com.dawes.modelo.TiendaVO)
	 */
	int insertar(TiendaVO tienda);

	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#modificar(com.dawes.modelo.TiendaVO)
	 */
	int modificar(TiendaVO tienda);

	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#eliminar(com.dawes.modelo.TiendaVO)
	 */
	int eliminar(TiendaVO tienda);

	/**
	 * @param nombre
	 * @return
	 * @see com.dawes.dao.TiendaDAO#findByNombre(java.lang.String)
	 */
	Optional<TiendaVO> findByNombre(String nombre);

	/**
	 * @return
	 * @see com.dawes.dao.TiendaDAO#findAll()
	 */
	Optional<List<TiendaVO>> findAll();

}