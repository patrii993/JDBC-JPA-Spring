package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.RolVO;
@Repository
public interface RolRepositorio extends CrudRepository<RolVO, Integer> {

}
