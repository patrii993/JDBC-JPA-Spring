package com.dawes.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ConciertoVO;
import com.dawes.modelo.SalaVO;

@Repository
public interface ConciertoRepositorio extends CrudRepository<ConciertoVO, Integer> {

	Optional<List<ConciertoVO>> findBySala(SalaVO sala);
	
	Optional<List<ConciertoVO>> findBySalaAndGrupoAndFechaBetween(SalaVO sala,String grupo, LocalDate from, LocalDate to);
	
	//array de conciertos en los que no haya ninguna grupo puesto
	@Query("select c from ConciertoVO c where c.grupo is null")
	Optional<List<ConciertoVO>> encuentraFechasLibres();
	
	Optional<List<ConciertoVO>> findByGrupoAndFecha(String grupo, LocalDate fecha);
	Optional<List<ConciertoVO>> findBySalaAndGrupo (SalaVO sala, String nombre);

}
