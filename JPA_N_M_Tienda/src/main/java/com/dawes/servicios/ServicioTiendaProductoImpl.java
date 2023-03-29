package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.dao.TiendaProductoDAO;
import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.TiendaProductoVO;
import com.dawes.util.DAOFactory;

public class ServicioTiendaProductoImpl implements ServicioTiendaProducto{
	private DAOFactory f;
	private TiendaProductoDAO tpd;

	public ServicioTiendaProductoImpl() {
		f=DAOFactory.conectar();
		tpd=f.getTiendaProductoDAOImpl();
	}

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#insertar(com.dawes.modelo.TiendaProductoVO)
	 */
	public int insertar(TiendaProductoVO tp) {
		return tpd.insertar(tp);
	}

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#modificar(com.dawes.modelo.TiendaProductoVO)
	 */
	public int modificar(TiendaProductoVO tp) {
		return tpd.modificar(tp);
	}

	/**
	 * @param tp
	 * @return
	 * @see com.dawes.dao.TiendaProductoDAO#elminar(com.dawes.modelo.TiendaProductoVO)
	 */
	public int elminar(TiendaProductoVO tp) {
		return tpd.elminar(tp);
	}

	/**
	 * @param producto
	 * @param tienda
	 * @param stock
	 * @return
	 */
	public Optional<List<TiendaProductoVO>> findByTiendaProductoStock(ProductoVO producto) {
		return tpd.findByTiendaProductoStock(producto);
	}


	

}
