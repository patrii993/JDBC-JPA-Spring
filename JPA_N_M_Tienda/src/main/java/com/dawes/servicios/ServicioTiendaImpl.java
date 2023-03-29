package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.dao.TiendaDAO;
import com.dawes.modelo.TiendaVO;
import com.dawes.util.DAOFactory;

public class ServicioTiendaImpl implements ServicioTienda {
		private DAOFactory f;
		private TiendaDAO td;
	public ServicioTiendaImpl() {
		f=DAOFactory.conectar();
		td=f.getTiendaDAOImpl();
	}
	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#insertar(com.dawes.modelo.TiendaVO)
	 */
	public int insertar(TiendaVO tienda) {
		return td.insertar(tienda);
	}
	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#modificar(com.dawes.modelo.TiendaVO)
	 */
	public int modificar(TiendaVO tienda) {
		return td.modificar(tienda);
	}
	/**
	 * @param tienda
	 * @return
	 * @see com.dawes.dao.TiendaDAO#eliminar(com.dawes.modelo.TiendaVO)
	 */
	public int eliminar(TiendaVO tienda) {
		return td.eliminar(tienda);
	}
	/**
	 * @param nombre
	 * @return
	 * @see com.dawes.dao.TiendaDAO#findByNombre(java.lang.String)
	 */
	public Optional<TiendaVO> findByNombre(String nombre) {
		return td.findByNombre(nombre);
	}
	/**
	 * @return
	 * @see com.dawes.dao.TiendaDAO#findAll()
	 */
	public Optional<List<TiendaVO>> findAll() {
		return td.findAll();
	}

}
