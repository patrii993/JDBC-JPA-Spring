package com.dawes.serviciosImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ConciertoVO;
import com.dawes.modelo.SalaVO;
import com.dawes.repositorio.ConciertoRepositorio;
import com.dawes.servicios.ServicioConcierto;

@Service
public class ServicioConciertoImpl implements ServicioConcierto {

	@Autowired
	ConciertoRepositorio cr;

	@Override
	public <S extends ConciertoVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public <S extends ConciertoVO> Iterable<S> saveAll(Iterable<S> entities) {
		return cr.saveAll(entities);
	}

	@Override
	public Optional<ConciertoVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return cr.existsById(id);
	}

	@Override
	public Iterable<ConciertoVO> findAll() {
		return cr.findAll();
	}

	@Override
	public Iterable<ConciertoVO> findAllById(Iterable<Integer> ids) {
		return cr.findAllById(ids);
	}

	@Override
	public long count() {
		return cr.count();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(ConciertoVO entity) {
		cr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		cr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends ConciertoVO> entities) {
		cr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cr.deleteAll();
	}

	@Override
	public Optional<List<ConciertoVO>> findBySala(SalaVO sala) {
		// TODO Auto-generated method stub
		return cr.findBySala(sala);
	}

	@Override
	public Optional<List<ConciertoVO>> findBySalaAndGrupoAndFechaBetween(SalaVO sala, String grupo,
			LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return cr.findBySalaAndGrupoAndFechaBetween(sala, grupo, from, to);
	}

	@Override
	public Optional<List<ConciertoVO>> encuentraFechasLibres() {
		// TODO Auto-generated method stub
		return cr.encuentraFechasLibres();
	}

	/**
	 * @param grupo
	 * @param fecha
	 * @return
	 * @see com.dawes.repositorio.ConciertoRepositorio#findByGrupoAndFecha(java.lang.String, java.time.LocalDate)
	 */
	public Optional<List<ConciertoVO>> findByGrupoAndFecha(String grupo, LocalDate fecha) {
		return cr.findByGrupoAndFecha(grupo, fecha);
	}

	/**
	 * @param sala
	 * @param nombre
	 * @return
	 * @see com.dawes.repositorio.ConciertoRepositorio#findBySalaAndGrupo(com.dawes.modelo.SalaVO, java.lang.String)
	 */
	public Optional<List<ConciertoVO>> findBySalaAndGrupo(SalaVO sala, String nombre) {
		return cr.findBySalaAndGrupo(sala, nombre);
	}




	
}
