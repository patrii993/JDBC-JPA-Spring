package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.dao.MedicamentoDAO;
import com.dawes.modelo.MedicamentoVO;
import com.dawes.util.DAOFactory;

public class ServicioMedicamentoImpl implements ServicioMedicamento {

	DAOFactory factoria;
	MedicamentoDAO md;
	public ServicioMedicamentoImpl() {
		factoria=DAOFactory.conectar();
		md=factoria.getMedicamentoDAOImpl();
	}
	public int insertar(MedicamentoVO medicamento) {
		return md.insertar(medicamento);
	}
	public int eliminar(MedicamentoVO medicamento) {
		return md.eliminar(medicamento);
	}
	public int modificar(MedicamentoVO medicamento) {
		return md.modificar(medicamento);
	}
	public Optional<MedicamentoVO> findByDenominacion(String denominacion) {
		return md.findByDenominacion(denominacion);
	}
	public Optional<List<MedicamentoVO>> findAll() {
		return md.findAll();
	}

}
