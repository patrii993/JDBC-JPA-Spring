package com.dawes.daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import com.dawes.dao.MedicamentoDAO;
import com.dawes.modelo.MedicamentoVO;
import com.dawes.modelo.PacienteVO;

public class MedicamentoDAOImpl implements MedicamentoDAO {

	EntityManager em;

	public MedicamentoDAOImpl(EntityManager em) {
		this.em = em;
	}

	public int insertar(MedicamentoVO medicamento) {
		try {
			em.getTransaction().begin();
			em.persist(medicamento);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				System.out.println("Esa denominacion de medicamente ya existe.");
				em.getTransaction().rollback();
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Hay un error al insertar paciente " + e.getMessage());
			em.getTransaction().rollback();

		}
		return 2;
	}

	public int eliminar(MedicamentoVO medicamento) {
		
		em.getTransaction().begin();
		em.remove(medicamento);
		em.getTransaction().commit();
		return 1;
	}

	public int modificar(MedicamentoVO medicamento) {
		
		em.getTransaction().begin();
		em.merge(medicamento);
		em.getTransaction().commit();
		return 1;
	}

	public Optional<MedicamentoVO> findByDenominacion(String denominacion) {
		try {
			TypedQuery<MedicamentoVO> medicamento = em
					.createQuery("select m from MedicamentoVO m where denominacion=?1", MedicamentoVO.class);
			medicamento.setParameter(1, denominacion);
			return Optional.of(medicamento.getSingleResult());
		} catch (PersistenceException e) {
			if (e.getLocalizedMessage().equals("No entity found for query")) {
				System.out.println("Esa denominacion de medicamento no existe ");
				return Optional.of(new MedicamentoVO());
			}
		} catch (Exception e) {
			System.out.println("Error en el método findByDni de PacienteDAOImpl " + e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<List<MedicamentoVO>> findAll() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
