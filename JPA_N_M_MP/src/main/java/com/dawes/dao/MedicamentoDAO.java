package com.dawes.dao;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.MedicamentoVO;

public interface MedicamentoDAO {
	int insertar(MedicamentoVO medicamento);
	int eliminar(MedicamentoVO medicamento);
	int modificar(MedicamentoVO medicamento);
	Optional<MedicamentoVO> findByDenominacion(String denominacion);
	Optional<List<MedicamentoVO>> findAll();
}
