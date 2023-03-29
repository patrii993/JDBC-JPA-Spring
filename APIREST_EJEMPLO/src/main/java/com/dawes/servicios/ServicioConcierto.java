package com.dawes.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ConciertoVO;
import com.dawes.modelo.SalaVO;

public interface ServicioConcierto {
	
	Optional<List<ConciertoVO>> encuentraFechasLibres();
	
	Optional<List<ConciertoVO>> findBySalaAndGrupoAndFechaBetween(SalaVO sala,String grupo, LocalDate from, LocalDate to);
	
	Optional<List<ConciertoVO>> findBySala(SalaVO sala);

	<S extends ConciertoVO> S save(S entity);

	<S extends ConciertoVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ConciertoVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ConciertoVO> findAll();

	Iterable<ConciertoVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ConciertoVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends ConciertoVO> entities);

	void deleteAll();
	Optional<List<ConciertoVO>> findByGrupoAndFecha(String grupo, LocalDate fecha);
	Optional<List<ConciertoVO>> findBySalaAndGrupo(SalaVO sala, String nombre);

}