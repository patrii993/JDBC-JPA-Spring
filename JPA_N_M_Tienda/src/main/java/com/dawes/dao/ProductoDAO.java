package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ProductoVO;

public interface ProductoDAO {
	int insertar(ProductoVO producto);
	int modificar(ProductoVO producto);
	int eliminar(ProductoVO producto);
	Optional<ProductoVO> findById(int id);
	Optional<List<ProductoVO>> findAll();


}
