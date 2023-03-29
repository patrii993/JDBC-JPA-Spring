package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.PacienteVO;

public interface ServicioPaciente {

	int insertar(PacienteVO paciente);

	int eliminar(PacienteVO paciente);

	int modificar(PacienteVO paciente);

	Optional<PacienteVO> findByDni(String dni);

	Optional<List<PacienteVO>> findAll();

}