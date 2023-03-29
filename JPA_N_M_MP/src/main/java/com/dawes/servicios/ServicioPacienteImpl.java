package com.dawes.servicios;

import java.util.List;
import java.util.Optional;

import com.dawes.dao.PacienteDAO;
import com.dawes.modelo.PacienteVO;
import com.dawes.util.DAOFactory;

public class ServicioPacienteImpl implements ServicioPaciente {

	DAOFactory factoria;
	PacienteDAO pd;
	public ServicioPacienteImpl() {
		factoria=DAOFactory.conectar();
		pd=factoria.getPacienteDAOImpl();
	}
	public int insertar(PacienteVO paciente) {
		return pd.insertar(paciente);
	}
	public int eliminar(PacienteVO paciente) {
		return pd.eliminar(paciente);
	}
	public int modificar(PacienteVO paciente) {
		return pd.modificar(paciente);
	}
	public Optional<PacienteVO> findByDni(String dni) {
		return pd.findByDni(dni);
	}
	public Optional<List<PacienteVO>> findAll() {
		return pd.findAll();
	}

}
