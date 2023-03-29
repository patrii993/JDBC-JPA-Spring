package com.dawes.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.MedicamentoVO;
import com.dawes.modelo.PacienteMedicamentoVO;
import com.dawes.modelo.PacienteVO;

public interface PacienteMedicamentoDAO {
	int insertar(PacienteMedicamentoVO pm);
	int eliminar(PacienteMedicamentoVO pm);
	int modificar(PacienteMedicamentoVO pm);
	Optional<List<PacienteMedicamentoVO>> findByPacienteYFecha(PacienteVO paciente,LocalDate inicio,LocalDate fin);
	Optional<List<PacienteMedicamentoVO>> findPacienteMayor60(PacienteVO paciente);
	
}
