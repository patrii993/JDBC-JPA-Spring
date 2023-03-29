package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ProductoVO;
import com.dawes.modelo.TiendaProductoVO;

public interface TiendaProductoDAO {
	int insertar(TiendaProductoVO tp);
	int modificar(TiendaProductoVO tp);
	int elminar(TiendaProductoVO tp);
	Optional<List<TiendaProductoVO>> findByTiendaProductoStock(ProductoVO producto);
	
	

}
