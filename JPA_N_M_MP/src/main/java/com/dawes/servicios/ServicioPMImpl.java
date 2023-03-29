package com.dawes.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.dao.PacienteMedicamentoDAO;
import com.dawes.modelo.PacienteMedicamentoVO;
import com.dawes.modelo.PacienteVO;
import com.dawes.util.DAOFactory;

public class ServicioPMImpl implements ServicioPM {

	DAOFactory factoria;
	PacienteMedicamentoDAO pmd;
	public ServicioPMImpl() {
		factoria=DAOFactory.conectar();
		pmd=factoria.getPacienteMedicamentoDAOImpl();
	}
	/**
	 * @param pm
	 * @return
	 * @see com.dawes.dao.PacienteMedicamentoDAO#insertar(com.dawes.modelo.PacienteMedicamentoVO)
	 */
	public int insertar(PacienteMedicamentoVO pm) {
		return pmd.insertar(pm);
	}
	/**
	 * @param pm
	 * @return
	 * @see com.dawes.dao.PacienteMedicamentoDAO#eliminar(com.dawes.modelo.PacienteMedicamentoVO)
	 */
	public int eliminar(PacienteMedicamentoVO pm) {
		return pmd.eliminar(pm);
	}
	/**
	 * @param pm
	 * @return
	 * @see com.dawes.dao.PacienteMedicamentoDAO#modificar(com.dawes.modelo.PacienteMedicamentoVO)
	 */
	public int modificar(PacienteMedicamentoVO pm) {
		return pmd.modificar(pm);
	}
	/**
	 * @param paciente
	 * @param inicio
	 * @param fin
	 * @return
	 * @see com.dawes.dao.PacienteMedicamentoDAO#findByPacienteYFecha(com.dawes.modelo.PacienteVO, java.time.LocalDate, java.time.LocalDate)
	 */
	public Optional<List<PacienteMedicamentoVO>> findByPacienteYFecha(PacienteVO paciente, LocalDate inicio,
			LocalDate fin) {
		return pmd.findByPacienteYFecha(paciente, inicio, fin);
	}
	/**
	 * @param pm
	 * @param fecha
	 * @return
	 * @see com.dawes.dao.PacienteMedicamentoDAO#findPacienteMayor60(com.dawes.modelo.PacienteMedicamentoVO, java.time.LocalDate)
	 */
	public Optional<List<PacienteMedicamentoVO>> findPacienteMayor60(PacienteVO paciente) {
		return pmd.findPacienteMayor60(paciente);
	}
	

}
