package com.dawes.daoImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import com.dawes.dao.PacienteMedicamentoDAO;
import com.dawes.modelo.PacienteMedicamentoVO;
import com.dawes.modelo.PacienteVO;

public class PacienteMedicamentoDAOImpl implements PacienteMedicamentoDAO {

	EntityManager em;

	public PacienteMedicamentoDAOImpl(EntityManager em) {
		this.em = em;
	}

	public int insertar(PacienteMedicamentoVO pm) {
		try {
			em.getTransaction().begin();
			em.persist(pm);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {

			System.out.println("Error al persistir en pacientemedicamento"+e.getMessage());
			em.getTransaction().rollback();
			return 0;

		} catch (Exception e) {
			System.out.println("Hay un error en el método insertar paciente " + e.getMessage());
			em.getTransaction().rollback();

		}
		return 2;
	}

	public int eliminar(PacienteMedicamentoVO pm) {
		
		em.getTransaction().begin();
		em.remove(pm);
		em.getTransaction().commit();
		return 1;
	}

	public int modificar(PacienteMedicamentoVO pm) {
		
		em.getTransaction().begin();
		em.merge(pm);
		em.getTransaction().commit();
		return 1;
	}

	public Optional<List<PacienteMedicamentoVO>> findByPacienteYFecha(PacienteVO paciente, LocalDate inicio,
			LocalDate fin) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public Optional<List<PacienteMedicamentoVO>> findPacienteMayor60(PacienteVO paciente) {
		
		try {
			TypedQuery<PacienteMedicamentoVO> pmedicacion= em.createQuery("select pm from PacienteMedicamentoVO pm, PacienteVO p where pm.paciente=?1 AND (floor(months_between(SYSDATE, pm.paciente.fechanacimiento)/12))>=60", PacienteMedicamentoVO.class);
			pmedicacion.setParameter(1, paciente.getIdpaciente()); //SIFECHA(fecha_inicial;fecha_final;"Y")
			List<PacienteMedicamentoVO> lista= pmedicacion.getResultList();
			return Optional.of(lista);
		} catch (PersistenceException e) {
			System.out.println("Error de persistencia " + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("Error en el método findPacienteMayor60" + e.getLocalizedMessage());
		}
		return Optional.empty();
	}

}
