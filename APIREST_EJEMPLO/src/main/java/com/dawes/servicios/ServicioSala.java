package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.SalaVO;

public interface ServicioSala {

	<S extends SalaVO> S save(S entity);

	<S extends SalaVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<SalaVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<SalaVO> findAll();

	Iterable<SalaVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(SalaVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends SalaVO> entities);

	void deleteAll();
	Optional<SalaVO> findByNombre(String nombre);

}