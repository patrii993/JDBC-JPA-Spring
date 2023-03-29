package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.PacienteVO;

public interface PacienteDAO {
	int insertar(PacienteVO paciente);
	int eliminar(PacienteVO paciente);
	int modificar(PacienteVO paciente);
	Optional<PacienteVO> findByDni(String dni);
	Optional<List<PacienteVO>> findAll();
}
