package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.SalaVO;
@Repository
public interface SalaRepositorio extends CrudRepository<SalaVO, Integer> {
	Optional <SalaVO> findByNombre(String nombre);

}
