package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.TiendaVO;

public interface TiendaDAO {
	int insertar (TiendaVO tienda);
	int modificar (TiendaVO tienda);
	int eliminar (TiendaVO tienda);
	Optional<TiendaVO> findByNombre(String nombre);
	Optional<List<TiendaVO>> findAll();

}
