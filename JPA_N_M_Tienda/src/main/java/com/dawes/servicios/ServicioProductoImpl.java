package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.dao.ProductoDAO;
import com.dawes.modelo.ProductoVO;
import com.dawes.util.DAOFactory;

public class ServicioProductoImpl implements ServicioProducto {
	private DAOFactory f;
	private ProductoDAO pd;
	
	public ServicioProductoImpl() {
	f=DAOFactory.conectar();
	pd=f.getProductoDAOImpl();
	
	}

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#insertar(com.dawes.modelo.ProductoVO)
	 */
	public int insertar(ProductoVO producto) {
		return pd.insertar(producto);
	}

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#modificar(com.dawes.modelo.ProductoVO)
	 */
	public int modificar(ProductoVO producto) {
		return pd.modificar(producto);
	}

	/**
	 * @param producto
	 * @return
	 * @see com.dawes.dao.ProductoDAO#eliminar(com.dawes.modelo.ProductoVO)
	 */
	public int eliminar(ProductoVO producto) {
		return pd.eliminar(producto);
	}

	/**
	 * @param id
	 * @return
	 * @see com.dawes.dao.ProductoDAO#findById(int)
	 */
	public Optional<ProductoVO> findById(int id) {
		return pd.findById(id);
	}

	/**
	 * @return
	 * @see com.dawes.dao.ProductoDAO#findAll()
	 */
	public Optional<List<ProductoVO>> findAll() {
		return pd.findAll();
	}
	

}
