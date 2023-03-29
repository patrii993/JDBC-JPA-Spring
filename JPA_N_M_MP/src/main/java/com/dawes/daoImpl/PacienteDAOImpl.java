package com.dawes.daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import com.dawes.dao.PacienteDAO;
import com.dawes.modelo.PacienteVO;

public class PacienteDAOImpl implements PacienteDAO {

	EntityManager em;

	public PacienteDAOImpl(EntityManager em) {
		this.em = em;
	}

	public int insertar(PacienteVO paciente) {
		try {
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				System.out.println("Ese dni del paciente ya existe.");
				em.getTransaction().rollback();
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Hay un error al insertar paciente " + e.getMessage());
			em.getTransaction().rollback();

		}
		return 2;
	}

	public int eliminar(PacienteVO paciente) {
		
		em.getTransaction().begin();
		em.remove(paciente);
		em.getTransaction().commit();
		return 1;
	}

	public int modificar(PacienteVO paciente) {
		
		em.getTransaction().begin();
		em.merge(paciente);
		em.getTransaction().commit();
		return 1;
	}

	public Optional<PacienteVO> findByDni(String dni) {

		try {
			TypedQuery<PacienteVO> paciente = em.createQuery("select p from PacienteVO p where dni=?1",
					PacienteVO.class);
			paciente.setParameter(1, dni);
			return Optional.of(paciente.getSingleResult());
		} catch (PersistenceException e) {
			if (e.getLocalizedMessage().equals("No entity found for query")) {
				System.out.println("Ese dni no existe ");
				return Optional.of(new PacienteVO());
			}
		} catch (Exception e) {
			System.out.println("Error en el método findByDni de PacienteDAOImpl " + e.getMessage());
		}
		return Optional.empty();
	}

	public Optional<List<PacienteVO>> findAll() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
