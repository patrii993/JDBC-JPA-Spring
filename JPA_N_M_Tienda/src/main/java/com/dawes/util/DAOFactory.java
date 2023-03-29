package com.dawes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.dawes.dao.ProductoDAO;
import com.dawes.dao.TiendaDAO;
import com.dawes.dao.TiendaProductoDAO;
import com.dawes.daoimpl.ProductoDAOImpl;
import com.dawes.daoimpl.TiendaDAOImpl;
import com.dawes.daoimpl.TiendaProductoDAOImpl;

public class DAOFactory {

	EntityManager em;
	private static DAOFactory factoria;
	
	private DAOFactory() {
		// TODO Auto-generated constructor stub
		try {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("tema3");
			em=emf.createEntityManager();
			
		} catch (PersistenceException e) {
			System.out.println("Error al conectar la base de datos " + e.getMessage());
		}
	}
	public static DAOFactory conectar() {
		if(factoria ==null) {
			factoria = new DAOFactory();
		}
		return factoria;
	}
	public TiendaDAO getTiendaDAOImpl() {
		return new TiendaDAOImpl(em);
	}
	
	public ProductoDAO getProductoDAOImpl() {
		return new ProductoDAOImpl(em);
	}
	
	public TiendaProductoDAO getTiendaProductoDAOImpl() {
		return new TiendaProductoDAOImpl(em);
	}

}
