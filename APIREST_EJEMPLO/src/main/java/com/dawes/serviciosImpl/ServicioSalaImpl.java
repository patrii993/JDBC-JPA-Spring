package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.SalaVO;
import com.dawes.repositorio.SalaRepositorio;
import com.dawes.servicios.ServicioSala;

@Service
public class ServicioSalaImpl implements ServicioSala {
	@Autowired
	SalaRepositorio sr;

	@Override
	public <S extends SalaVO> S save(S entity) {
		return sr.save(entity);
	}

	/**
	 * @param nombre
	 * @return
	 * @see com.dawes.repositorio.SalaRepositorio#findByNombre(java.lang.String)
	 */
	

	@Override
	public <S extends SalaVO> Iterable<S> saveAll(Iterable<S> entities) {
		return sr.saveAll(entities);
	}


	/**
	 * @param nombre
	 * @return
	 * @see com.dawes.repositorio.SalaRepositorio#findByNombre(java.lang.String)
	 */
	public Optional<SalaVO> findByNombre(String nombre) {
		return sr.findByNombre(nombre);
	}

	@Override
	public Optional<SalaVO> findById(Integer id) {
		return sr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return sr.existsById(id);
	}

	@Override
	public Iterable<SalaVO> findAll() {
		return sr.findAll();
	}

	@Override
	public Iterable<SalaVO> findAllById(Iterable<Integer> ids) {
		return sr.findAllById(ids);
	}

	@Override
	public long count() {
		return sr.count();
	}

	@Override
	public void deleteById(Integer id) {
		sr.deleteById(id);
	}

	@Override
	public void delete(SalaVO entity) {
		sr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		sr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends SalaVO> entities) {
		sr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		sr.deleteAll();
	}




	

}
