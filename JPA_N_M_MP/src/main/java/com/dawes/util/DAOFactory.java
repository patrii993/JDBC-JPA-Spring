package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.dawes.dao.MedicamentoDAO;
import com.dawes.dao.PacienteDAO;
import com.dawes.dao.PacienteMedicamentoDAO;
import com.dawes.daoImpl.MedicamentoDAOImpl;
import com.dawes.daoImpl.PacienteDAOImpl;
import com.dawes.daoImpl.PacienteMedicamentoDAOImpl;

public class DAOFactory {

	public EntityManager em;
	private static DAOFactory factoria;

	private DAOFactory() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("tema3");
			em = emf.createEntityManager();
		} catch (PersistenceException e) {
			System.out.println("Error al conectar a la base de datos " + e.getLocalizedMessage());
		}
	}

	public PacienteDAO getPacienteDAOImpl() {
		return new PacienteDAOImpl(em);
	}

	public MedicamentoDAO getMedicamentoDAOImpl() {
		return new MedicamentoDAOImpl(em);
	}

	public PacienteMedicamentoDAO getPacienteMedicamentoDAOImpl() {
		return new PacienteMedicamentoDAOImpl(em);
	}

	public static DAOFactory conectar() {
		if (factoria == null)
			factoria = new DAOFactory();
		return factoria;
	}
}
