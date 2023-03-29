package com.dawes.servicioImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.repositorio.UsuarioRolRepositorio;

@Service
public class ServicioUsuarioRolImpl implements ServicioUsuarioRol {
	@Autowired
	UsuarioRolRepositorio urr;

	/**
	 * @param <S>
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends UsuarioRolVO> S save(S entity) {
		return urr.save(entity);
	}

	/**
	 * @param <S>
	 * @param entities
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#saveAll(java.lang.Iterable)
	 */
	@Override
	public <S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities) {
		return urr.saveAll(entities);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@Override
	public Optional<UsuarioRolVO> findById(Integer id) {
		return urr.findById(id);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#existsById(java.lang.Object)
	 */
	@Override
	public boolean existsById(Integer id) {
		return urr.existsById(id);
	}

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	public Iterable<UsuarioRolVO> findAll() {
		return urr.findAll();
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAllById(java.lang.Iterable)
	 */
	@Override
	public Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids) {
		return urr.findAllById(ids);
	}

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count() {
		return urr.count();
	}

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Integer id) {
		urr.deleteById(id);
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(UsuarioRolVO entity) {
		urr.delete(entity);
	}

	/**
	 * @param ids
	 * @see org.springframework.data.repository.CrudRepository#deleteAllById(java.lang.Iterable)
	 */
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		urr.deleteAllById(ids);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#deleteAll(java.lang.Iterable)
	 */
	@Override
	public void deleteAll(Iterable<? extends UsuarioRolVO> entities) {
		urr.deleteAll(entities);
	}

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
		urr.deleteAll();
	}
	

}
